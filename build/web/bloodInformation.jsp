<%-- 
    Document   : index
    Created on : Oct 5, 2016, 5:20:08 PM
    Author     : pavan
--%>

<%@page import="java.util.Iterator"%>
<%@page import="com.Beans.FormBeans"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<!DOCTYPE html>
<html>
    <title>E-MedicalCenterManagementSystem</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="css/w3.css">
    <link rel="stylesheet" href="css/w3-theme-black.css">
    <link rel="stylesheet" href="icons/font-awesome.min.css">
    <link rel="stylesheet" href="css/base.css">
    <body id="myPage">


        <div class="w3-top">
            <ul class="w3-navbar w3-theme-d2 w3-left-align">
                <li class="w3-hide-medium w3-hide-large w3-opennav w3-right">
                    <a class="w3-hover-white w3-theme-d2" href="javascript:void(0);" onclick="openNav()"><i class="fa fa-bars"></i></a>
                </li>
                <li><a href="index.jsp" class="w3-teal"><i class="fa fa-home w3-margin-right"></i>Home</a></li>
                <li class="w3-hide-small"><a href="#team" class="w3-hover-white">Our Doctors</a></li>
                <li class="w3-hide-small"><a onclick="document.getElementById('id01').style.display='block'" style="width:auto;" class="w3-hover-white">Admin</a></li>
                <li class="w3-hide-small"><a onclick="document.getElementById('id02').style.display='block'" style="width:auto;"class="w3-hover-white">Patient</a></li>
                <li class="w3-hide-small"><a onclick="document.getElementById('id04').style.display='block'" style="width:auto;" class="w3-hover-white">Patient SignUP</a></li>
                
                <li class="w3-hide-small w3-dropdown-hover">
                    <a href="javascript:void(0);" title="Notifications">Other Branches Medicine<i class="fa fa-caret-down"></i></a>     
                    <div class="w3-dropdown-content w3-white w3-card-4">
                      <a href="./OtherBranchesAction?branch=Nashua">Nashua</a>
                            <a href="./OtherBranchesAction?branch=Manchester">Manchester</a>
                            <a href="./OtherBranchesAction?branch=Londonderry">Londonderry</a>
                    </div>
                </li>
                <li class="w3-hide-small"><a href="./BloodInformation" class="w3-hover-white">Blood Information</a></li>
                <li class="w3-hide-small"><a href="#contact" class="w3-hover-white">Contact Us</a></li>
                <li class="w3-hide-small w3-right"><a href="#" class="w3-hover-teal" title="Search"><i class="fa fa-phone"></i></a></li>
            </ul>

            <!-- Navbar on small screens -->
            <div id="navDemo" class="w3-hide w3-hide-large w3-hide-medium">
                <ul class="w3-navbar w3-left-align w3-theme">
                    <li><a onclick="document.getElementById('id01').style.display='block'" class="w3-btn w3-xlarge w3-theme w3-hover-teal">Admin</a></li>
                    <li><a onclick="document.getElementById('id02').style.display='block'" class="w3-btn w3-xlarge w3-theme w3-hover-teal">Patient</a></li>
                    <li class="w3-hide-small"><a onclick="document.getElementById('id04').style.display='block'" style="width:auto;" w3-hover-white">Patient SignUp</a></li>
                    <li><a href="#contact">Contact Us</a></li>

                    <li class="w3-dropdown-hover">
                        <a href="javascript:void(0);" title="Notifications">Other Branches Medicine and Blood<i class="fa fa-caret-down"></i></a>     
                        <div class="w3-dropdown-content w3-light-grey w3-card-4">
                            <a href="./OtherBranchesAction?branch=Nashua">Nashua</a>
                            <a href="./OtherBranchesAction?branch=Manchester">Manchester</a>
                            <a href="./OtherBranchesAction?branch=Londonderry">Londonderry</a>
                        </div>
                    </li>
                </ul>
            </div>
        </div>

        <!-- Image Header -->
        <div class="w3-display-container w3-animate-opacity">
           <!--Patient signup-->
           <% String signup=(String)request.getAttribute("signUp");
            if(signup!=null){
             %>   
            <div class="alert">
                <span class="closebtn" onclick="this.parentElement.style.display='none';">&times;</span>
                <strong>Status</strong> <%= signup%>
            </div>

             <%    
             
             }
                    
        %>  <% String loginError=(String)request.getAttribute("loginError");
            if(loginError!=null){
             %>   
            <div class="alert">
                <span class="closebtn" onclick="this.parentElement.style.display='none';">&times;</span>
                <strong>Status</strong> <%= loginError%>
            </div>

             <%    
             
             }
                    
        %> 
        <% String errorMessage=(String)request.getAttribute("errorMessage");
            if(errorMessage!=null){
             %>   
            <div class="alert">
                <span class="closebtn" onclick="this.parentElement.style.display='none';">&times;</span>
                <strong>Status</strong> <%= errorMessage%>
            </div>

             <%    
             
             }
                    
        %> 
            
            
        </div>
        
         <hr>
        <div class="w3-center">
            <h2>Blood Donor Information</h2>
            <!--  <p>The color themes have been designed to work harmoniously with each other.</p>-->
        </div>
    
<div class="w3-row-padding">

           <div class="w3-table w3-center" >
               
               <table class="w3-table-all">
                   <tbody>
                       <tr class="w3-teal" ><th>Name</th><th>Blood Group</th><th>Age</th><th>City</th><th>Mobile</th><th>E-mail</th></tr>
   
     
        <%
        ArrayList<FormBeans> history=(ArrayList<FormBeans>)request.getAttribute("blood");
         Iterator<FormBeans> it= history.iterator();
      while(it.hasNext()){
      
      FormBeans rfb=(FormBeans)it.next();

%>
 
       
                   <tr>
                       <td><%=rfb.getDonorName()%></td>
                       <td> <%=rfb.getGroup()%></td>
                        <td><%=rfb.getDonorAge()%></td>
                         <td><%=rfb.getDonorCity()%></td>
                          <td><%=rfb.getDonorMobile()%></td>
                    <td><%=rfb.getDonorEmail()%></td>
                   
                   
                   </tr>
                  <%}%>
                   </tbody>
               </table> 
               
           </div>
      
                       

</div>
        
        

        <!--      Patient signUP-->
        <div id="id04" class="modal">
 
            <form class="modal-content animate" action="./SingUpAction">
                <div class="imgcontainer">
                    <span onclick="document.getElementById('id04').style.display='none'" class="close" title="Close Modal">&times;</span>
                    <img src="img/avatar.jpg" alt="Avatar" class="avatar w3-label">
                    <h2 class="w3-label">Patient SignUp Form</h2>
              
                </div>

                <div class="container">

                    <div class="w3-group">      
                        <input class="w3-input" type="text" name="fname" required>
                        <label class="w3-label">Full Name</label>
                    </div>
                    <div class="w3-group">      
                        <input class="w3-input" type="text" name="uname"required>
                        <label class="w3-label">User Name</label>
                    </div>
                    <div class="w3-group">      
                        <input class="w3-input" type="password" name="psw"required>
                        <label class="w3-label">Password</label>
                    </div>
                    <div class="w3-group">      
                        <input class="w3-input" type="number"name="mobile" required>
                        <label class="w3-label">Mobile</label>
                    </div>
                    <div class="w3-group">      
                        <input class="w3-input" type="email"name="email" required>
                        <label class="w3-label">E-mail</label>
                    </div>
                    <div class="w3-group">     

                        <input class="w3-input" type="number" name="age"required>
                        <label class="w3-label ">Age</label>
                    </div>
                    <div class="w3-group">

                        <input id="male" class="w3-radio" type="radio" name="gender" value="male" checked>
                        <label class="w3-validate">Male</label>

                        <input id="female" class="w3-radio" type="radio" name="gender" value="female">

                        <label class="w3-validate">Female</label>
                    </div>





                    <div class="w3-group">      
                        <button type="submit" class="w3-hover-teal">SIGN UP</button>
                    </div>

                </div>

                <div class="container" style="background-color:#f1f1f1">
                    <button type="button" onclick="document.getElementById('id04').style.display='none'" class="cancelbtn">Cancel</button>

                </div>
            </form>
        </div>
        <script>
            // Get the modal
            var modal = document.getElementById('id04');

            // When the user clicks anywhere outside of the modal, close it
            window.onclick = function(event) {
                if (event.target == modal) {
                    modal.style.display = "none";
                }
            }
        </script>

        <!--End signUp-->




        <!--login model form-->



        <div id="id02" class="modal">

            <form class="modal-content animate" action="./PatientLoginAction">
                <div class="imgcontainer">
                    <span onclick="document.getElementById('id02').style.display='none'" class="close" title="Close Modal">&times;</span>
                    <img src="img/avatar.jpg" alt="Avatar" class="avatar">
                    <h2>Patient Login Form</h2>
                </div>

                <div class="container">
                    <label><b>Username</b></label>
                    <input type="text" placeholder="Enter Username" name="uname" required>

                    <label><b>Password</b></label>
                    <input type="password" placeholder="Enter Password" name="psw" required>

                    <button type="submit">Login</button>
                    <input type="checkbox" checked="checked"> Remember me
                </div>

                <div class="container" style="background-color:#f1f1f1">
                    <button type="button" onclick="document.getElementById('id02').style.display='none'" class="cancelbtn">Cancel</button>
                    <span class="psw">Forgot <a href="#">password?</a></span>
                </div>
            </form>
        </div>

        <script>
            // Get the modal
            var modal = document.getElementById('id02');

            // When the user clicks anywhere outside of the modal, close it
            window.onclick = function(event) {
                if (event.target == modal) {
                    modal.style.display = "none";
                }
            }
        </script>
        <!--end patient login-->
        <!--admin model form-->



        <div id="id01" class="modal">

            <form class="modal-content animate" action="./AdminLoginAction">
                <div class="imgcontainer">
                    <span onclick="document.getElementById('id01').style.display='none'" class="close" title="Close Modal">&times;</span>
                    <img src="img/avatar.jpg" alt="Avatar" class="avatar">
                    <h2>Admin Login Form</h2>
                </div>

                <div class="container">
                    <label><b>Username</b></label>
                    <input type="text" placeholder="Enter Username" name="uname" required>

                    <label><b>Password</b></label>
                    <input type="password" placeholder="Enter Password" name="psw" required>

                    <button type="submit">Login</button>
                    <input type="checkbox" checked="checked"> Remember me
                </div>

                <div class="container" style="background-color:#f1f1f1">
                    <button type="button" onclick="document.getElementById('id01').style.display='none'" class="cancelbtn">Cancel</button>
                    <span class="psw">Forgot <a href="#">password?</a></span>
                </div>
            </form>
        </div>

        <script>
            // Get the modal
            var modal = document.getElementById('id01');

            // When the user clicks anywhere outside of the modal, close it
            window.onclick = function(event) {
                if (event.target == modal) {
                    modal.style.display = "none";
                }
            }
        </script>
        <!--end admin form-->


        <div id="id03" class="w3-modal">
            <div class="w3-modal-content w3-card-8 w3-animate-top">
                <header class="w3-container w3-teal"> 
                    <span onclick="document.getElementById('id03').style.display='none'" class="w3-closebtn"><i class="fa fa-remove"></i></span>
                    <h4>E-Medical Center Management System</h4>
                    <h5>Our Working System <i class="fa fa-smile-o"></i></h5>
                </header>
                <div class="w3-container">
                    <p>The E-Medical Center management System is developed to decrease the work that's done manually at Hospital centers. each single step is finished with the assistance of system, services like worker registration , written material of various varieties like staff , students into info , inquiries further as complaints of consumers And doctors information . In this system we are providing the book an  appointment for consulting doctor.  </p>

                </div>
                <footer class="w3-container w3-teal">
                    <p>Thank You for Your Support!!<i class="fa fa-smile-o"></i></p>
                </footer>
            </div>
        </div>
        <script>
            // Get the modal
            var modal = document.getElementById('id03');

            // When the user clicks anywhere outside of the modal, close it
            window.onclick = function(event) {
                if (event.target == modal) {
                    modal.style.display = "none";
                }
            }
        </script>
        <!-- Team Container -->
        <div class="w3-container w3-padding-64 w3-center" id="team">
            <h2>OUR DOCTORS</h2>
            <p>Meet the Our Doctors</p>

            <div class="w3-row"><br>

           

                <div class="w3-quarter">
                    <img src="img/hospital.jpg" alt="Boss" style="width:45%" class="w3-circle w3-hover-opacity">
                    <h3>ch pavan</h3>
                    <p>General</p>
                </div>

                <div class="w3-quarter">
                    <img src="img/hospital.jpg" alt="Boss" style="width:45%" class="w3-circle w3-hover-opacity">
                    <h3>Rebecca Flex</h3>
                    <p>general</p>
                </div>

                <div class="w3-quarter">
                    <img src="img/hospital.jpg" alt="Boss" style="width:45%" class="w3-circle w3-hover-opacity">
                    <h3>Jan Ringo</h3>
                    <p>General</p>
                </div>

                <div class="w3-quarter">
                    <img src="img/hospital.jpg" alt="Boss" style="width:45%" class="w3-circle w3-hover-opacity">
                    <h3>Kai Ringo</h3>
                    <p>General</p>
                </div>

            </div>
        </div>

        <!-- Work Row -->



        <!-- Contact Container -->
        <div class="w3-container w3-padding-64 w3-theme-l5" id="contact">
            <div class="w3-row">
                <div class="w3-col m5">
                    <div class="w3-padding-16"><span class="w3-xlarge w3-border-teal w3-bottombar">Contact Us</span></div>
                    <h3>Address</h3>
                    <p>14 new castle drive </p>
                    <p><i class="fa fa-map-marker w3-text-teal w3-xlarge"></i>&nbsp;&nbsp;Apt 06,Nashua, NH</p>
                    <p><i class="fa fa-phone w3-text-teal w3-xlarge"></i>&nbsp;&nbsp;+00 8183783783</p>
                    <p><i class="fa fa-envelope-o w3-text-teal w3-xlarge"></i>&nbsp;&nbsp;Hospital@hospital.com</p>
                </div>
                <div class="w3-col m7">
                    <form class="w3-container w3-card-4 w3-padding-16 w3-white">
                        <div class="w3-group">      
                            <label class="w3-label">Name</label>
                            <input class="w3-input" type="text">
                        </div>
                        <div class="w3-group">      
                            <label class="w3-label">Email</label>
                            <input class="w3-input" type="text">
                        </div>
                        <div class="w3-group">      
                            <label class="w3-label">Subject</label>
                            <input class="w3-input" type="text">
                        </div>  
                        <input class="w3-check" type="checkbox" checked>
                        <label class="w3-validate">I Like it!</label>
                        <button type="button" class="w3-btn w3-right w3-theme">Send</button>
                    </form>
                </div>
            </div>
        </div>


        <!-- Footer -->
        <footer class="w3-container w3-padding-32 w3-theme-d1 w3-center">
            <h4>Follow Us</h4>
            <a class="w3-btn-floating w3-teal" href="javascript:void(0)" title="Facebook"><i class="fa fa-facebook"></i></a>
            <a class="w3-btn-floating w3-teal" href="javascript:void(0)" title="Twitter"><i class="fa fa-twitter"></i></a>
            <a class="w3-btn-floating w3-teal" href="javascript:void(0)" title="Google +"><i class="fa fa-google-plus"></i></a>
            <a class="w3-btn-floating w3-teal w3-hide-small" href="javascript:void(0)" title="Linkedin"><i class="fa fa-linkedin"></i></a>
            <p>Powered by <a href="#" target="_blank">pavan</a></p>

            <div style="position:relative;bottom:100px;z-index:1;" class="w3-tooltip w3-right">
                <span class="w3-text w3-padding w3-teal w3-hide-small">Go To Top</span>   
                <a class="w3-btn w3-theme" href="#myPage"><span class="w3-xlarge">
                        <i class="fa fa-chevron-circle-up"></i></span></a>
            </div>
        </footer>

        <!-- Script For Side Navigation -->
        <script>
            function w3_open() {
                var x = document.getElementById("mySidenav");
                x.style.width = "300px";
                x.style.textAlign = "center";
                x.style.fontSize = "40px";
                x.style.paddingTop = "10%";
                x.style.display = "block";
            }
            function w3_close() {
                document.getElementById("mySidenav").style.display = "none";
            }

            // Used to toggle the menu on smaller screens when clicking on the menu button
            function openNav() {
                var x = document.getElementById("navDemo");
                if (x.className.indexOf("w3-show") == -1) {
                    x.className += " w3-show";
                } else { 
                    x.className = x.className.replace(" w3-show", "");
                }
            }
        </script>

    </body>

</html>