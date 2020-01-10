import random
import math
from view import Graph, Console

# create the blank canvas for operating on.
# worldmap: 2D array, 10x10. contains each sector
def blankmap():
    worldmap = [ [None] * 10 for i in range(10) ]
    for i in range(10):
        for q in range(10):
            worldmap[i][q] = [ [ False for z in range(25) ] for j in range(25) ]
    return worldmap

# populate the map with binary data from random
# density is 0-100
def populaterandom(sector, density=50):
    for x in range(len(sector)):
        for y in range(len(sector)):
            n = random.randint(0, 100)
            sector[x][y] = True if n <= density else False

# Populates a map based on an elementary cellular automaton
# This NEEDS to be cleaned up when I'm not stoned
def populateca(sector):
    y = int()
    for y in range(len(sector)):
        for x in range(1, len(sector)-1):
            if y == 0:
                sector[math.floor(len(sector)/2)][0] = True
                break
            if sector[x-1][y-1]^sector[x+1][y-1]:
                sector[x][y] = True

# ceullular automaton method from http://www.roguebasin.com/index.php?title=Cellular_Automata_Method_for_Generating_Random_Cave-Like_Levels
def iscavewall(surround, threshold):
    count = 0
    for i in surround:
        if i:
            count += 1

    if count >= threshold:
        return True
    else:
        return False

def applycaveca(sector, threshold=4):
    for y in range(len(sector)):
        for x in range(len(sector)):
            try:
                sector[x][y] = iscavewall([sector[x-1][y-1], sector[x][y-1], sector[x+1][y-1], sector[x-1][y], sector[x+1][y], sector[x-1][y+1], sector[x][y+1], sector[x+1][y+1]], threshold)
            except IndexError:
                break


def mapassector(world):
    sector = []
    for yw in range(len(world)):
        for ys in range(len(world[0][0])):
            row = []
            for xw in range(len(world)):
                for xs in range(len(world[0][0])):
                    row.append(world[xw][yw][xs][ys])
            sector.append(row)
    print(len(sector))
    return sector


def test():
    world = blankmap()
    world1 = mapassector(world)
    populaterandom(world1, density=40)
    applycaveca(world1, threshold=4)
    Graph.drawsector(world1)

test()
