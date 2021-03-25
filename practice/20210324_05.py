# 문제 문자열 재정렬

numbers = ['0','1','2','3','4','5','6','7','8','9']
data = list(input())
data.sort()

num_sum = 0
result = ''
for i in data:
    if i in numbers:
        num_sum += int(i)
    else:
        result += i
if num_sum != 0:
    result += str(num_sum)

print(result)
    