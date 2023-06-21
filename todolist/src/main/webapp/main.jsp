<%@ page import="src.main.java.dto.Todo" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>할 일 목록 페이지</title>
  <link rel="stylesheet" type="text/css" href="main.css"/>

</head>
<body>
<header>
  <%
    List<Todo> list = (List<Todo>) request.getAttribute("todos");
    if(list != null) {
      for(Todo todo : list) {
        System.out.println("=== " + todo.toString());
      }
    }
    else System.out.println("It is null");
  %>
  <button class="header_button" onclick="location.href='/todolist/form'">
    새로운 TODO 등록
  </button>
</header>
<div id="main_container">
  <!-- todo -->
  <div class="main_state_container">
    <div class="main_title">
      TODO
    </div>
    <ul class="main_items_container">
      <li class="main_item_container">
        <div class="main_item_wrapper">
          <div class="main_item_title">
            타이틀
          </div>
          <div class="main_item_content">
            등록날짜 2023.99.99, 전소영, 우선순위 1
          </div>
        </div>
        <button class="main_item_button">
          ➡️
        </button>
      </li>
    </ul>
  </div>
  <!-- doing -->
  <div class="main_state_container">
    <div class="main_title">
      DOING
    </div>
    <ul class="main_items_container">
      <li class="main_item_container">
        <div class="main_item_wrapper">
          <div class="main_item_title">
            타이틀
          </div>
          <div class="main_item_content">
            등록날짜 2023.99.99, 전소영, 우선순위 1
          </div>
        </div>
        <button class="main_item_button">
          ➡️
        </button>
      </li>
      <li class="main_item_container">
        <div class="main_item_wrapper">
          <div class="main_item_title">
            타이틀
          </div>
          <div class="main_item_content">
            등록날짜 2023.99.99, 전소영, 우선순위 1
          </div>
        </div>
        <button class="main_item_button">
          ➡️
        </button>
      </li>
      <li class="main_item_container">
        <div class="main_item_wrapper">
          <div class="main_item_title">
            타이틀
          </div>
          <div class="main_item_content">
            등록날짜 2023.99.99, 전소영, 우선순위 1
          </div>
        </div>
        <button class="main_item_button">
          ➡️
        </button>
      </li>
    </ul>
  </div>
  <!-- done -->
  <div class="main_state_container">
    <div class="main_title">
      DONE
    </div>
    <ul class="main_items_container">
      <li class="main_item_container">
        <div class="main_item_wrapper">
          <div class="main_item_title">
            타이틀
          </div>
          <div class="main_item_content">
            등록날짜 2023.99.99, 전소영, 우선순위 1
          </div>
        </div>
        <button class="main_item_button">
          ➡️
        </button>
      </li>
    </ul>
  </div>

</div>
<footer>
  <div>
    ssoyeong@boostcouse
    <br>
    https://github.com/ssoyeong
  </div>
</footer>

<script src="main.js"></script>
</body>
</html>