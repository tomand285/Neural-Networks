import sys, json, numpy as np
import nnfs
from nnfs.datasets import spiral_data

nnfs.init()

def main():
    req = json.loads(sys.argv[1])
    mode = req["mode"]
    option = req["option"]
    
    if(mode == "spiral_data"):
        size = option["size"]
        X, y = spiral_data(size[0], size[1])

        print(json.dumps({"X":X.tolist(),"y":y.tolist()}))

#start process
if __name__ == '__main__':
    main()