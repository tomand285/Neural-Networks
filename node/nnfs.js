const math = require("mathjs");

var nnfs = {
    datasets: {
        spiral_data: (points, classes)=>{
                let X = math.zeros([points*classes, 2]);
                let y = math.zeros([points*classes]);
                var ix = 0;
                for(let class_number = 0; class_number < classes; class_number++){
                    let r = 0;
                    let t = class_number*4;
                    while(r <= 1 && t <= (class_number + 1) * 4) {
            			let random_t = t+math.random(-1, 1)*0.2;
    
            			X[ix][0] = r * math.sin(random_t * 2.5);
            			X[ix][1] = r * math.cos(random_t * 2.5);
            			y[ix] = class_number;
            
            			r += 1.0 / (points - 1); 
            			t += 4.0 / (points - 1);
            
            			ix++;
            		}
                }
                return {X:math.matrix(X), y:math.matrix(y)};
        },
        spiral_data_nnfs: async (points, classes)=>{
            return await pythonRequest("spiral_data",{"size":[points,classes]});
        }
    }
};

function pythonRequest(mode, option){
    return new Promise((resolve, reject) => {
       var spawn = require('child_process').spawn;
        var data = {"mode":mode,"option":option};
        var py    = spawn('python3', ['compute_input.py',JSON.stringify(data)]);
        var dataString = '';
        
        py.stdout.on('data', function(data){
            dataString += data.toString();
        });
        py.stdout.on('end', function(){
            let X = math.matrix(JSON.parse(dataString).X);
            let y = math.matrix(JSON.parse(dataString).y);
            resolve({X:X, y:y});
        });
        py.stdin.write(JSON.stringify(data));
        py.stdin.end(); 
    });
}

module.exports = nnfs;