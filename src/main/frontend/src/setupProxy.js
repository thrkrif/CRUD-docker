// // # main/frontend/src/setupProxy.js
// const { createProxyMiddleware } = require('http-proxy-middleware');
//
// // "/api" 경로가 시작하면 프록시 미들웨어를 실행한다.
// module.exports = function(app) {
//     app.use(
//         '/api',
//         createProxyMiddleware({
//             target: 'http://localhost:8080',
//             changeOrigin: true
//         })
//     );
// };
const { createProxyMiddleware } = require('http-proxy-middleware');

module.exports = function(app) {
    app.use(
        '/api',
        createProxyMiddleware({
            // target: 'http://localhost:8080', // 로컬에서 백엔드 서버 주소
            target: 'http://spring-crud-container2:8080',
            changeOrigin: true,
        })
    );
};
