# OAUTH2认证服务器（仅实现授权码模式）

#### 使用说明
1.通过携带特定信息（客户端信息、登陆成功跳转路径等）的url访问认证服务器
2.认证服务器跳转到登录页面（已实现自定义登陆页面，登陆页面中包含验证码的校验）
3.用户名、密码、验证码校验正确后跳转到授权页面（已实现授权页的自定义），确认授权
4.跳转到之前设定好的登陆成功跳转路径，并在url中携带code
5.提供接口，实现通过code换取Token
6.提供接口，实现校验Token，如果正确则返回用户基本信息（用户名、权限等）

#### 功能作用解释
为商城提供三方登录