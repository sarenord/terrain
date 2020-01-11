import random

# populate the map with binary data from random
# density is 0-100
def populaterandom(sector, density=50):
    for x in range(len(sector)):
        for y in range(len(sector)):
            n = random.randint(0, 100)
            sector[x][y] = True if n <= density else False


# Populates a map based on an elementary cellular automaton
def populateca(sector):
    y = int()
    for y in range(len(sector)):
        for x in range(1, len(sector)-1):
            if y == 0:
                sector[math.floor(len(sector)/2)][0] = True
                break
            if sector[x-1][y-1]^sector[x+1][y-1]:
                sector[x][y] = True

def iscavewall(surround, threshold):
    count = 0
    for i in surround:
        if i:
            count += 1

    if count >= threshold:
        return True
    else:
        return False

# CA method from http://www.roguebasin.com/index.php?title=Cellular_Automata_Method_for_Generating_Random_Cave-Like_Levels
def applycaveca(sector, threshold=4):
    for y in range(len(sector)):
        for x in range(len(sector)):
            try:
                sector[x][y] = iscavewall([sector[x-1][y-1], sector[x][y-1], sector[x+1][y-1], sector[x-1][y], sector[x+1][y], sector[x-1][y+1], sector[x][y+1], sector[x+1][y+1]], threshold)
            except IndexError:
                break
