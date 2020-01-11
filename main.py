import random
import math
from view import Graph, Console
import transform

# create the blank canvas for operating on.
# worldmap: 2D array, 10x10. contains each sector
def blankmap():
    worldmap = [ [None] * 10 for i in range(10) ]
    for i in range(10):
        for q in range(10):
            worldmap[i][q] = [ [ False for z in range(25) ] for j in range(25) ]
    return worldmap

def mapassector(world):
    sector = []
    for yw in range(len(world)):
        for ys in range(len(world[0][0])):
            row = []
            for xw in range(len(world)):
                for xs in range(len(world[0][0])):
                    row.append(world[xw][yw][xs][ys])
            sector.append(row)
    return sector


def test():
    world = blankmap()
    world1 = mapassector(world)
    transform.populaterandom(world1, density=35)
    transform.applycaveca(world1, threshold=4)
    Graph.drawsector(world1)

test()
