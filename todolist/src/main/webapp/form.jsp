<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>할 일 등록 페이지</title>
  <link rel="stylesheet" type="text/css" href="form.css"/>

</head>
<body>
<header>
  할 일 등록
</header>
<div id="main_container">
  <div class="main_items_container">
    <div class="main_item_container">
      <div class="main_item_question">
        어떤 일인가요?
      </div>
      <input class="main_item_input">
    </div>
    <div class="main_item_container">
      <div class="main_item_question">
        누가 할 일인가요?
      </div>
      <input class="main_item_input">
    </div>
    <div class="main_item_container">
      <div class="main_item_question">
        우선 순위를 선택하세요
      </div>
      <div class="main_item_radio_wrapper">
        <label class="main_item_radio">
          <input type="radio" name="rank">
          <span>1순위</span>
          </input>
        </label>
        <label class="main_item_radio">
          <input type="radio" name="rank">
          <span>2순위</span>
          </input>
        </label>
        <label class="main_item_radio">
          <input type="radio" name="rank">
          <span>3순위</span>
          </input>
        </label>
      </div>
    </div>
  </div>
  <div class="main_buttons_container">
    <div class="main_buttons_wrapper">
      <button class="main_button_previous" onclick="location.href='/todolist/main.jsp'">이전</button>
    </div>
    <div class="main_buttons_wrapper">
      <button class="main_button_form">제출</button>
      <button class="main_button_form">내용 지우기</button>
    </div>
  </div>
</div>
<footer>
  <div>
    ssoyeong@boostcouse
    <br>
    https://github.com/ssoyeong
  </div>
</footer>

<script src="form.js"></script>
</body>
</html>
