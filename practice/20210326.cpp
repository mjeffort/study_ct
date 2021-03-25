#include <bits/stdc++.h>

using namespace std;

// stack
// stack<int> s;

// int main(void) {
//     s.push(5);
//     s.push(2);
//     s.push(3);
//     s.push(7);
//     s.pop();
//     s.push(1);
//     s.push(4);
//     s.pop();

//     while (!s.empty()) {
//         cout << s.top() << ' ';
//         s.pop();
//     }
// }

// queue
queue<int> q;

int main(void) {
    q.push(5);
    q.push(2);
    q.push(3);
    q.push(7);
    q.pop();
    q.push(1);
    q.push(4);
    q.pop();

    while (!q.empty()) {
        cout << q.front() << ' ';
        q.pop();
    }
}