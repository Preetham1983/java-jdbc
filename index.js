
// single thread can manage multiple connections
// non blocking io model 
// apache has a thread for 1 req
// npm  node package mannager(pacakegs install)

// server.mjs
const { createServer } = require('http');

const server = createServer((req, res) => {
  res.statusCode = 200;
  res.setHeader('Content-Type', 'text/plain');
  // res.end('Hello, World!\n');
  res.end('i want to be the man who iam in the world\n');
});

server.listen(3000, '127.0.0.1', () => {
  console.log('Server running at http://127.0.0.1:3000/');
});


// run with `node server.mjs`
