# DFS & BFS
# queue

# from collections import deque
# #큐(Queue)  구현을 위해 deque  라이브러리 사용
# queue = deque()

# queue.append(5)
# queue.append(2)
# queue.append(3)
# queue.append(7)
# queue.popleft()
# queue.append(1)
# queue.append(4)
# queue.popleft()

# print(queue)
# queue.reverse()
# print(queue)

## 재귀함수
## recursive

def factorial_recursive(n):
    if n <= 1:
        return 1

    return n * factorial_recursive(n-1)

print(factorial_recursive(5))

def gcd(a, b):
    print(a,b)
    if a%b == 0:
        return b
    else:
        return gcd(b, a%b)

print(gcd(192, 162))
print(gcd(162, 192))