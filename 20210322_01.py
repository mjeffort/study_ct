# 쉬운 풀이
# n, k = map(int, input().split())
# cnt = 0

# while n != 1:
#     if n%k == 0:
#         n = n/k
#     else:
#         n = n - 1
#     cnt += 1

# print(cnt)

# logn 시간복잡도
n, k = map(int, input().split())
result = 0

while True:
    # k로 나누어 질 수 있는 수 
    target = (n//k) * k
    result += (n - target)
    n = target
    
    if n < k:
        break
    # 나누어 질 때
    result += 1
    n //= k

result += (n - 1)
print(result)


print(result)