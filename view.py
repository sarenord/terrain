from PIL import Image, ImageDraw


# print the map or a portion of the map to the console in a way that makes sense
# until I have a better method of displaying this info (other than to console) this is probably best used only with sectors
class Console:
    def prettyprintsector(sector):
        black_char = '\u2588'
        white_char = '\u2582'
        worldflag = type(sector[0][0]) == list

        for y in range(len(sector)):
            line = []
            for x in range(len(sector)):
                line.append( (white_char, black_char)[sector[x][y]] )
                line.append( (white_char, black_char)[sector[x][y]] )

            print(''.join(line))

class Graph:
    def drawmap(data):
        size = len(data[0])*len(data[0][0])*10
        img = Image.new("RGB", (size, size), (255, 255, 255))
        draw = ImageDraw.Draw(img)

        for xw in range(10):
            for yw in range(10):
                for xs in range(25):
                    for ys in range(25):
                        x1 = xw*250+xs*10
                        y1 = yw*250+ys*10
                        if data[xw][yw][xs][ys] == True:
                            draw.rectangle([(x1, y1), (x1+10, y1+10)], fill="black")
        img.show()
        img.save("/tmp/map", "JPEG")



    def drawsector(sector):
        size = len(sector[0])*10
        img = Image.new("RGB", (size, size), (255, 255, 255))
        draw = ImageDraw.Draw(img)

        for x in range(len(sector)):
            for y in range(len(sector[x])):
                if sector[x][y]:
                    draw.rectangle([(25*x, 25*y), (25*x+25, 25*y+25)], fill="black")

        img.show()
        img.save("/tmp/sector", "JPEG")
