# import time
# start_time = time.time()

# end_time = time.time()
# print("time: ", end_time - start_time)

# a = int(1e9)
# print(a)


# n = 4
# m = 3
# # array = [[0] * m] * n
# array = [[0] * m for _ in range(n) ]
# print(array)

# array[1][1]= 5
# print(array)

# import sys

# data = sys.stdin.readline().rstrip()
# print(data)

# list1 = [1,2,3,4,5]
# list2 = [6,7,8,9,10]

# result = map(lambda a, b: (a, b), list1, list2)

# print(list(result))

result = eval("(4+4)**2")
print(result)

array = [(1, 34), (2, 75), (3,100)]
result = sorted(array, key=lambda x:x[1], reverse=True)
print(result)

from itertools import permutations
from itertools import combinations
from itertools import product
from itertools import combinations_with_replacement

data = ['A', 'B', 'C']
result = list(permutations(data, 2))
print(result)

result = list(combinations(data, 3))
print(result)


result = list(product(data, repeat = 2))
print(result)

result = list(combinations_with_replacement(data, 2))
print(result)

from collections import Counter

counter = Counter(['blue', 'red', 'red', 'green', 'blue', 'blue'])

counter_dict = dict(counter)
print(counter_dict)
print(sorted(counter_dict.items(), key=lambda x:x[1]))
print(sorted(counter_dict, key=lambda x:x[1]))
