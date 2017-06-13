<!DOCTYPE html>
<html lang="pt">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
          <link rel="icon" href="../../favicon.ico">

        <title>Docelânida</title>

        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <script src="js/jquery.min.js"></script>
        <script src="js/bootstrap.js"></script>
        <!--<link href="css/sprtd.css" rel="stylesheet" type="text/css"/>-->

        <link href="css/carousel.css" rel="stylesheet">
    </head>
    <!-- NAVBAR
    ================================================== -->
    <body>
        <nav class="navbar navbar-inverse" role="navigation">
            <div class="container-fluid">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="menu.jsp">Docelandia</a>
                </div>
                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                    <ul class="nav navbar-nav">
                        <li><a href="#">Gerenciar dados</a></li>


                    </ul>
                    </li>
                    </ul>
                    <ul class="nav navbar-nav navbar-right">
                        <li><a href="#">Usuário: <strong><%= session.getId()%>&nbsp;&nbsp;</strong><span id="totMsgTopo" class="text-danger"></span></a></li>
                    </ul>
                </div>
            </div>
        </nav>
