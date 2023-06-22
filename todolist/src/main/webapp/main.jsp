<%@ page import="src.main.java.dto.Todo" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.StringTokenizer" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>할 일 목록 페이지</title>
  <link rel="stylesheet" type="text/css" href="main.css"/>

</head>
<body>
<header>
  <button class="header_button" onclick="location.href='/todolist/form'">
    새로운 TODO 등록
  </button>
</header>
<div id="main_container">
  <%
    StringTokenizer st = null;
    // 타입별 할 일 목록
    List<Todo> todolist = (List<Todo>) request.getAttribute("todoList");
    List<Todo> doingList = (List<Todo>) request.getAttribute("doingList");
    List<Todo> doneList = (List<Todo>) request.getAttribute("doneList");
  %>
  <!-- todo -->
  <div class="main_state_container">
    <div class="main_title">
      TODO
    </div>
    <ul class="main_items_container">
      <%
        if(todolist.size() != 0) {
          for(Todo todoItem : todolist) {
      %>
      <li class="main_item_container">
        <div class="main_item_wrapper">
          <%
            String title = todoItem.getTitle();
            st = new StringTokenizer(todoItem.getRegDate());
            String date = st.nextToken();
            String name = todoItem.getName();
            int sequence = todoItem.getSequence();
          %>
          <div class="main_item_title">
            <%=title%>
          </div>
          <div class="main_item_content">
            등록날짜 <%=date%>, <%=name%>, 우선순위 <%=sequence%>
          </div>
        </div>
        <button class="main_item_button">
          ➡️
        </button>
      </li>
      <%
          }
        }
      %>
    </ul>
  </div>
  <!-- doing -->
  <div class="main_state_container">
    <div class="main_title">
      DOING
    </div>
    <ul class="main_items_container">
      <%
        if(doingList.size() != 0) {
          for(Todo todoItem : doingList) {
      %>
      <li class="main_item_container">
        <div class="main_item_wrapper">
          <%
            String title = todoItem.getTitle();
            st = new StringTokenizer(todoItem.getRegDate());
            String date = st.nextToken();
            String name = todoItem.getName();
            int sequence = todoItem.getSequence();
          %>
          <div class="main_item_title">
            <%=title%>
          </div>
          <div class="main_item_content">
            등록날짜 <%=date%>, <%=name%>, 우선순위 <%=sequence%>
          </div>
        </div>
        <button class="main_item_button">
          ➡️
        </button>
      </li>
      <%
          }
        }
      %>
    </ul>
  </div>
  <!-- done -->
  <div class="main_state_container">
    <div class="main_title">
      DONE
    </div>
    <ul class="main_items_container">
      <%
        if(doneList.size() != 0) {
          for(Todo todoItem : doneList) {
      %>
      <li class="main_item_container">
        <div class="main_item_wrapper">
          <%
            String title = todoItem.getTitle();
            st = new StringTokenizer(todoItem.getRegDate());
            String date = st.nextToken();
            String name = todoItem.getName();
            int sequence = todoItem.getSequence();
          %>
          <div class="main_item_title">
            <%=title%>
          </div>
          <div class="main_item_content">
            등록날짜 <%=date%>, <%=name%>, 우선순위 <%=sequence%>
          </div>
        </div>
        <button class="main_item_button">
          ➡️
        </button>
      </li>
      <%
          }
        }
      %>
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