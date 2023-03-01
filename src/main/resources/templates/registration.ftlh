<html lang="en"><input type="hidden" id="__yoroi_connector_api_injected_type" value="prod"><head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Please sign in</title>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous">
    <link href="https://getbootstrap.com/docs/4.0/examples/signin/signin.css" rel="stylesheet" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <form action="/registration" class="form-signin" method="post" >
                <div class="form-group">
                    <label for="name">Имя пользователя</label>
                    <input type="text" class="form-control" required id="name" name="name">
                </div>
                <div class="form-group">
                    <label for="email">Электронная почта</label>
                    <input type="email" class="form-control" id="email" required name="email">
                </div>
                <div class="form-group">
                    <label for="phoneNumber">Номер телефона</label>
                    <input type="text" class="form-control" id="phoneNumber" required name="phoneNumber">
                </div>
                <div class="form-group">
                    <label for="password">Пароль</label>
                    <input type="password" class="form-control" id="password" required name="password">
                </div>
                <input type="hidden" name="_csrf" value="${_csrf.token}">
                <button type="submit" style="width: 100%" class="btn btn-dark">Зарегистрироваться</button>
            </form>
            <#if errorMessage??>
                <h2 style="color: red">${errorMessage}</h2>
            </#if>

</div>
</body>
</html>