# 문제 왕실의 나이트
x = ['1', '2', '3', '4', '5', '6', '7', '8']
y = ['a', 'b', 'c', 'd', 'e', 'f', 'g', 'h']
move_X = [1, 2, 1, 2, -1, -2, -1, -2]
move_Y = [2, 1, -2, -1, 2, 1, -2, -1]

pos = input()

xi = x.index(pos[1])
yi = y.index(pos[0])

# print(xi, yi)
result = 0
for i in range(8):
    if xi+move_X[i] >= 0 and xi+move_X[i] < 8 and yi+move_Y[i] >= 0 and yi+move_Y[i] < 8:
        result += 1

print(result)