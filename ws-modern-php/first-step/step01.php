<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <style>
        .body-1 {background-color: red;}
        .body-2 {background-color: green;}
        .body-3 {background-color: blue;}
    </style>
</head>
<body class="body-<?php echo rand(1,3);?>">
    Really <?php echo '<h1>nice</h1>'; ?>
</body>
</html>