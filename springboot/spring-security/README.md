
client 

2023-07-31T22:07:17.882+08:00 Saved request http://localhost:7999/messages?continue
2023-07-31T22:07:17.884+08:00 Redirecting to http://localhost:7999/oauth2/authorization/messaging-client-oidc
2023-07-31T22:07:17.922+08:00 Redirecting to http://localhost:8500/oauth2/authorize?response_type=code&client_id=messaging-client&scope=openid%20profile&state=3zrh4Jsr2-fDT4k089szW7dEH60wXKHXauI8ZKXuKmg%3D&redirect_uri=http://127.0.0.1:7999/login/oauth2/code/messaging-client-oidc&nonce=2FF9p6UpJkevMr8xZYMV4WTXVT3ZVzFfVCRGL2lKxsY

2023-07-31T22:24:45.429+08:00 Redirecting to http://localhost:8500/oauth2/authorize?response_type=code&client_id=messaging-client&scope=openid%20profile&state=k2vWWOrAGw0fEl_TggvjOMdrvLe4bRxgDosYe0X-JRY%3D&redirect_uri=http://127.0.0.1:7999/login/oauth2/code/messaging-client-oidc&nonce=tAyyY-ntPO2uX6pZ6dgt0FcRoFZgwBgzebhElptqdrk


server
2023-07-31T22:07:17.941+08:00 Securing GET /oauth2/authorize?response_type=code&client_id=messaging-client&scope=openid%20profile&state=3zrh4Jsr2-fDT4k089szW7dEH60wXKHXauI8ZKXuKmg%3D&redirect_uri=http://127.0.0.1:7999/login/oauth2/code/messaging-client-oidc&nonce=2FF9p6UpJkevMr8xZYMV4WTXVT3ZVzFfVCRGL2lKxsY
2023-07-31T22:07:25.360+08:00 Saved request http://localhost:8500/oauth2/authorize?response_type=code&client_id=messaging-client&scope=openid%20profile&state=3zrh4Jsr2-fDT4k089szW7dEH60wXKHXauI8ZKXuKmg%3D&redirect_uri=http://127.0.0.1:7999/login/oauth2/code/messaging-client-oidc&nonce=2FF9p6UpJkevMr8xZYMV4WTXVT3ZVzFfVCRGL2lKxsY&continue
2023-07-31T22:07:25.362+08:00 Redirecting to http://localhost:8500/login

登录页面
2023-07-31T22:15:14.558+08:00 Redirecting to http://localhost:8500/oauth2/authorize?response_type=code&client_id=messaging-client&scope=openid%20profile&state=3zrh4Jsr2-fDT4k089szW7dEH60wXKHXauI8ZKXuKmg%3D&redirect_uri=http://127.0.0.1:7999/login/oauth2/code/messaging-client-oidc&nonce=2FF9p6UpJkevMr8xZYMV4WTXVT3ZVzFfVCRGL2lKxsY&continue
2023-07-31T22:15:14.582+08:00 Securing GET /oauth2/authorize?response_type=code&client_id=messaging-client&scope=openid%20profile&state=3zrh4Jsr2-fDT4k089szW7dEH60wXKHXauI8ZKXuKmg%3D&redirect_uri=http://127.0.0.1:7999/login/oauth2/code/messaging-client-oidc&nonce=2FF9p6UpJkevMr8xZYMV4WTXVT3ZVzFfVCRGL2lKxsY&continue
2023-07-31T22:15:14.687+08:00 Redirecting to http://localhost:8500/oauth2/consent?scope=openid%20profile&client_id=messaging-client&state=CHc5JwPBd14JI6wBfhKP1RKDCjDbZR9v1iKqML8YDDI%3D

授权页面
2023-07-31T22:24:41.359+08:00 Redirecting to http://127.0.0.1:7999/login/oauth2/code/messaging-client-oidc?code=wjfU2yZrRwwpAiytHAMNjOTxYfd1xfLm-BKkVU2jywxPuBIH8C8dJd95Lao7-sOA_BbWznUMs1JBEdutjWhVcHHPDrLNER1pH0c-GLWGGot5NJYzZurbU-7IuKhu3tsO&state=3zrh4Jsr2-fDT4k089szW7dEH60wXKHXauI8ZKXuKmg%3D
2023-07-31T22:24:45.442+08:00 Securing GET /oauth2/authorize?response_type=code&client_id=messaging-client&scope=openid%20profile&state=k2vWWOrAGw0fEl_TggvjOMdrvLe4bRxgDosYe0X-JRY%3D&redirect_uri=http://127.0.0.1:7999/login/oauth2/code/messaging-client-oidc&nonce=tAyyY-ntPO2uX6pZ6dgt0FcRoFZgwBgzebhElptqdrk
2023-07-31T22:24:45.461+08:00 Redirecting to http://127.0.0.1:7999/login/oauth2/code/messaging-client-oidc?code=9ECaLUP5qszov1sypHZuiJON--JpK6D7hZXRM2HOIVEcsz4AUyzy_4wKZz0vXdjuw5bQWUmrKe58N5XUtraRLCM61P1wWLS1ADh3EMQEtXyfSU1a1QWxEMmHmMzOGQox&state=k2vWWOrAGw0fEl_TggvjOMdrvLe4bRxgDosYe0X-JRY%3D
2023-07-31T22:24:45.494+08:00 HTTP POST http://localhost:8500/oauth2/token
2023-07-31T22:24:45.497+08:00 Writing [{grant_type=[authorization_code], code=[9ECaLUP5qszov1sypHZuiJON--JpK6D7hZXRM2HOIVEcsz4AUyzy_4wKZz0vXdjuw5bQWUmrKe58N5XUtraRLCM61P1wWLS1ADh3EMQEtXyfSU1a1QWxEMmHmMzOGQox], redirect_uri=[http://127.0.0.1:7999/login/oauth2/code/messaging-client-oidc]}] as "application/x-www-form-urlencoded;charset=UTF-8"


为什么会这么写
AuthorizeHttpRequestsConfigurer
static final AuthorizationManager<RequestAuthorizationContext> permitAllAuthorizationManager = (a, o) -> {
return new AuthorizationDecision(true);
};