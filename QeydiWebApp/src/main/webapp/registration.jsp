<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <link rel="stylesheet" href="assets/css/registration.css">
    <link rel="stylesheet" href="https://unicons.iconscout.com/release/v4.0.0/css/line.css">

    <title>Registration page </title>
</head>

<body>
<div class="container">
    <header>Trainer Registration Form</header>

    <form action="registration" method="post">
        <div class="form first">
            <div class="details personal">
                <span class="title">Personal Details</span>

                <div class="fields">
                    <div class="input-field">
                        <label>Email</label>
                        <input type="email" placeholder="Enter your email" name="email" required>
                    </div>

                    <div class="input-field">
                        <label>Password</label>
                        <input type="password" placeholder="Enter your password" name="password" required>
                    </div>

                    <div class="input-field">
                        <label>Name</label>
                        <input type="text" placeholder="Enter your name" name="name" required>
                    </div>

                    <div class="input-field">
                        <label>Surname</label>
                        <input type="text" placeholder="Enter your surname" name="surname" required>
                    </div>

                    <div class="input-field">
                        <label>Age</label>
                        <input type="number" placeholder="Eynter your age" name="age" required>
                    </div>

                    <div class="input-field">
                        <label>University you graduated from</label>
                        <input type="text" placeholder="Enter University" name="university" required>
                    </div>

                    <div class="input-field">
                        <label>Point</label>
                        <input type="number" placeholder="Enter your University point" name="point" required>
                    </div>

                    <div class="input-field">
                        <label>Experience</label>
                        <input type="text" placeholder="Enter your Experience" name="experience" required>
                    </div>

                    <div class="input-field">
                        <label>Teachway</label>
                        <select name="teachway" required>
                            <option disabled selected>Select Teachway</option>
                            <option value="1">Attestat</option>
                            <option value="2">Abituriyent</option>
                            <option value="3">Magistratura</option>
                            <option value="4">Doktorantura</option>
                            <option value="5">Dovlet Qulluğu</option>
                            <option value="6">IT</option>
                            <option value="7">Mühasibatlıq</option>
                        </select>
                    </div>

                    <div class="input-field">
                        <label>Subject</label>
                        <select name="subject" required>
                            <option disabled selected>Select Subject</option>
                            <option value="1">Azərbaycan dili</option>
                            <option value="2">Riyaziyyat</option>
                            <option value="3">İngilis Dili</option>
                            <option value="4">Rus Dili</option>
                            <option value="5">Kimya</option>
                            <option value="6">Fizika</option>
                            <option value="7">Cografiya</option>
                            <option value="8">Tarix</option>
                            <option value="9">Ədəbiyyat</option>
                            <option value="10">Biologiya</option>
                            <option value="11">İnformatika</option>
                            <option value="12">Məntiq</option>
                            <option value="13">Qanunvericilik</option>
                            <option value="14">Java Development</option>
                            <option value="15">Web Development</option>
                            <option value="16">Pyhton</option>
                            <option value="17">PL/SQL</option>
                            <option value="18">Oracle SQL</option>
                            <option value="19">PHP</option>
                            <option value="20">Game Development</option>
                            <option value="21">1C</option>
                        </select>
                    </div>

                    <div class="input-field">
                        <label>Enter Discord Code</label>
                        <input type="text" placeholder="Enter #Code" name="code" required>
                    </div>

                    <div class="input-field">
                        <label>Cost Azn</label>
                        <input type="number" placeholder="Enter Cost" name="cost" required>
                    </div>
                </div>
            </div>


            <button class="nextBtn">
                <span class="btnText">Next</span>
                <i class="uil uil-navigator"></i>
            </button>
        </div>
</form>
</div>

<script src="registration.js"></script>

</body>
</html>
