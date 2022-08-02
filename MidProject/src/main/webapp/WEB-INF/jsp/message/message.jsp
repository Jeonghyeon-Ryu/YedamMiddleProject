<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!DOCTYPE html>
    <html lang="en">
    
    <head>
      <meta charset="UTF-8">
      <meta http-equiv="X-UA-Compatible" content="IE=edge">
      <meta name="viewport" content="width=device-width, initial-scale=1.0">
      <title>Document</title>
       <link rel="stylesheet" href="https://unpkg.com/aos@2.3.1/dist/aos.css"> 
       <script src="https://unpkg.com/aos@2.3.1/dist/aos.js"></script>  
      <link rel="stylesheet" href="css/message.css">
    </head>
    
    <body>
      <div id="container">
        <header>
          <h1>메시지함</h1>
          <button onclick="openMenu()" id="btn1"><img src="/img/icon.png">
          </button>
        </header>
        <div id="menu">
          <button onclick="openAllMs()">모든메시지</button>
          <button onclick="openSaveMs()">보관처리한메시지</button>
          <button onclick="openNotReadMs()">읽지않은메시지</button>
        </div>
    
        <nav>
          <div id="condition1" onclick="openAllMs()">
            메시지
          </div>
          <div id="condition2" onclick="openSaveMs()">
            보관처리됨
          </div>
          <div id="condition3" onclick="openNotReadMs()">
            읽지않음
          </div>
          <div id="condition4" onclick ="openNoticeMs()">
            <div>
              알림
            </div>
            <div id="num">
              1
            </div>
          </div>
        </nav>
        <hr>
        <div id="content1">모든 메시지</div>
        <div id="content2">저장된 메시지</div>
        <div id="content3">읽지않은 메시지</div>
        <div id="content4">알림</div>
      </div>
      <script src="js/message.js">
   
      </script>
    </body>
    
    </html>