<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>QR</title>
</head>
<body>

    <h1>Hello, guess what text is below??</h1>
    <img src="/MyQRCode.png" alt="qr image" style="">
    <hr>
    <h1>Below QR text is: <#if decodedText??> ${decodedText} </#if></h1>
    <img src="/QRCode.png" alt="qr image" style="">


</body>
</html>