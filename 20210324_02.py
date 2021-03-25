# 문제 상하좌우

n = int(input())
data = list(input().split())

pos = [1, 1]

for i in data:
    if i == 'R' and pos[1] < n:
        pos[1] += 1
    elif i == 'L' and pos[1] > 1:
        pos[1] -= 1
    elif i == 'U' and pos[0] > 1:
        pos[0] -= 1
    elif i == 'D' and pos[0] < n:
        pos[0] += 1

print(pos[0], pos[1])