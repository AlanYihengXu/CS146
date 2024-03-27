def floodFill(self, image, sr, sc, color):
    if image[sr][sc] is color:
        return
    old = image[sr][sc]
    image[sr][sc] = color
    if sr+1 < len(image) and image[sr+1][sc] is old:
        floodFill(self, image, sr+1, sc, color)
    if sr-1 >= 0 and image[sr-1][sc] is old:
        floodFill(self, image, sr-1, sc, color)
    if sc+1 < len(image[0]) and image[sr][sc+1] is old:
        floodFill(self, image, sr, sc+1, color)
    if sc-1 >= 0 and image[sr][sc-1] is old:
        floodFill(self, image, sr, sc-1, color)

image = [[1,1,1],
         [1,1,0],
         [1,0,1]]
floodFill(None, image, 1, 1, 2)
print(image)

image = [[0,0,0],
         [0,0,0]]
floodFill(None, image, 0, 0, 0)
print(image)