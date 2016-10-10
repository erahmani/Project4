<!DOCTYPE html>
<html lang="fa" >
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <style type="text/css">
        html, body {
            height: 100%;
        }

        ul.makeMenu, ul.makeMenu ul {
            width: 160px; /* sets the size of the menu blocks */
            border: 1px solid #000; /* puts a black border around the menu blocks */
            background-color: #8aa; /* makes the menu blocks mint green - a bg-color MUST be included for IE to work properly! */
            padding-left: 0px; /* stops the usual indent from ul */
            cursor: default; /* gives an arrow cursor */
            margin-left: 0px; /* Opera 7 final's margin and margin-box model cause problems */
        }

        ul.makeMenu li {
            list-style-type: none; /* removes the bullet points */
            margin: 0px; /* Opera 7 puts large spacings between li elements */
            position: relative;
            /* makes the menu blocks be positioned relative to their parent menu item
                                    the lack of offset makes these appear normal, but it will make a difference
                                    to the absolutely positioned child blocks */
            color: #fff; /* sets the default font colour to white */
        }

        ul.makeMenu li > ul { /* using the > selector prevents many lesser browsers (and IE - see below) hiding child ULs */
            display: none; /* hides child menu blocks - one of the most important declarations */
            position: absolute; /* make child blocks hover without leaving space for them */
            top: 2px; /* position slightly lower than the parent menu item */
            left: 160px;
            /* this must not be more than the width of the parent block, or the mouse will
                            have to move off the element to move between blocks, and the menu will close */
        }

        ul.makeMenu li:hover, ul.makeMenu li.CSStoHighlight {
            background-color: #ffa; /* gives the active menu items a yellow background */
            color: #000; /* makes the active menu item text black */
        }

        ul.makeMenu ul.CSStoShow { /* must not be combined with the next rule or IE gets confused */
            display: block; /* specially to go with the className changes in the behaviour file */
        }

        ul.makeMenu li:hover > ul {
            /* one of the most important declarations - the browser must detect hovering over arbitrary elements
                                          the > targets only the child ul, not any child uls of that child ul */
            display: block; /* makes the child block visible - one of the most important declarations */
        }

        /* and some link styles */
        ul.makeMenu li a {
            color: #fff;
            display: block;
            width: 100%;
            text-decoration: underline;
        }

        ul.makeMenu li a:hover, ul.makeMenu li a.CSStoHighLink {
            color: #000;
        }

        ul.makeMenu li:hover > a {
            color: #000;
        }
    </style>
</head>

<body>
<ul class="makeMenu">
    <li> مشتری
        <ul>
            <li><a href="CustomerRegistration.jsp">ثبت نام مشتری </a></li>
            <li><a href="SearchCustomer.jsp">جستجوی مشتری</a></li>
        </ul>
    </li>
    <li> تسهیلات
        <ul>
            <li><a href="LoanFileCreation.html">ایجاد پرونده ی تسهیلاتی</a></li>
            <li><a href="LoanTypeCreation.jsp">ایجاد نوع تسهیلات</a></li>
        </ul>
    </li>
</ul>
</body>
</html>

