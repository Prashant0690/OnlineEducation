<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../footer/taglib.jsp"%>



   <!-- Header
   ================================================== -->
   <div class="container">
   <div class="jumbotron">
	  <h1>${resumeModel.yourName != null ? resumeModel.yourName : "" }</h1>
	  <p>${resumeModel.yourOpeningCmt != null ? resumeModel.yourOpeningCmt : "" }** Let's <a class="smoothscroll" href="#about">start scrolling</a>
            and learn more <a class="smoothscroll" href="#about">about me</a>....</p>
       <ul class="nav navbar-nav">
               <li><a href="#"><i class="fa fa-facebook"></i></a></li>
               <li><a href="#"><i class="fa fa-twitter"></i></a></li>
               <li><a href="#"><i class="fa fa-google-plus"></i></a></li>
               <li><a href="#"><i class="fa fa-linkedin"></i></a></li>
               <li><a href="#"><i class="fa fa-instagram"></i></a></li>
               <li><a href="#"><i class="fa fa-dribbble"></i></a></li>
               <li><a href="#"><i class="fa fa-skype"></i></a></li>
            </ul>
            <nav>
			  <ul class="pager">
			    <li><a href='<spring:url value="${backLink}" />'>Back</a></li>
			  </ul>
			</nav>
	  
	</div>
	</div>

      

  


   <!-- About Section
   ================================================== -->
   
   <div class="container-fluid" >
  <div class="row">
  
   	<div class="col-md-2" ></div>
   	
  	<div class="col-md-8">
  		<div class="row">
  			<div class="col-md-3">
  				<img src="" alt="..." class="img-responsive img-thumbnail">
  			</div>
  			<div class="col-md-9">
  				
  				<h3>About Me</h3>
  				<p class="text-center"> ${resumeModel.aboutMe != null ? resumeModel.aboutMe : "" } </p>
  				<hr>
  					
  			</div>
  		</div>	
  	</div>
  	
  	<div class="col-md-2"></div>
  </div>
</div>



  

   <!-- Resume Section
   ================================================== -->
  
      <!-- Education
      ----------------------------------------------- -->
 <div class="container-fluid" >
  <div class="row"  >
  
   	<div class="col-md-2" ></div>
   	
  	<div class="col-md-8">
  		<div class="row">
  			<div class="col-md-3">
  				<h1><span>EDUCATION</span></h1>
  			</div>
  			<div class="col-md-9">
  				<p>${resumeModel.aboutEducation != null ? resumeModel.aboutEducation : "" }</p>
	  			<c:forEach items="${resumeModel.resumeInfoList}" var="eduItem">
	  			<c:if test="${eduItem.infoType == 'Education' }">
	  				
	  				<h3> ${eduItem.infoLine1 != null ? eduItem.infoLine1 : "" } 
		  				<a  href="#${eduItem.infoId}"  data-toggle="collapse">
			  			 	<span class="glyphicon glyphicon-menu-down" aria-hidden="true"></span>
			  			 </a>
	  				</h3>
	  				<div class="collapse" id="${eduItem.infoId}">
	                  <p class="info"> ${eduItem.infoLine2 != null ? eduItem.infoLine2 : "" } <span>&bull;</span>
	                   <em class="date"> ${eduItem.infoPeriod != null ? eduItem.infoPeriod : "" } </em></p>
	                  <p> ${eduItem.infoContent != null ? eduItem.infoContent : "" } </p>
	                </div>
	                
	             </c:if>
	             </c:forEach>
             <!-- ======================================================================== -->
             <hr>
  			 </div>
  			</div>
  		</div>	
  	<div class="col-md-2"></div>
  </div>
</div>


      <!-- Work
      ----------------------------------------------- -->
<div class="container-fluid" >
  <div class="row"  >
  
   	<div class="col-md-2" ></div>
   	
  	<div class="col-md-8">
  		<div class="row">
  			<div class="col-md-3">
  				<h1><span>WORK</span></h1>
  			</div>
  			<div class="col-md-9">
  			<p>${resumeModel.aboutWork != null ? resumeModel.aboutWork : "" }</p>
  			<c:forEach items="${resumeModel.resumeInfoList}" var="eduItem">
	  		<c:if test="${eduItem.infoType == 'Work' }">
  				<h3> ${eduItem.infoLine1 != null ? eduItem.infoLine1 : "" } 
	  				<a  href="#${eduItem.infoId}"  data-toggle="collapse">
		  			 	<span class="glyphicon glyphicon-menu-down" aria-hidden="true"></span>
		  			 </a>
  				</h3>
  				<div class="collapse" id="${eduItem.infoId}">
                  <p class="info"> ${eduItem.infoLine2 != null ? eduItem.infoLine2 : "" } <span>&bull;</span> 
                  <em class="date"> ${eduItem.infoPeriod != null ? eduItem.infoPeriod : "" } </em></p>
                  <p> ${eduItem.infoContent != null ? eduItem.infoContent : "" } </p>
                </div>
  			</c:if></c:forEach>
                
                <hr>
  			</div>
  			
  		</div>	
  	</div>
  	
  	<div class="col-md-2"></div>
  	
 
  </div>
</div>


      <!-- Skills
      ----------------------------------------------- -->
<div class="container-fluid" >
  <div class="row"  >
  
   	<div class="col-md-2" ></div>
   	
  	<div class="col-md-8">
  		<div class="row">
  			<div class="col-md-3">
  				<h1><span>SKILLS</span></h1>
  			</div>
  			<div class="col-md-9">
  				
  				<p>${resumeModel.aboutSkills != null ? resumeModel.aboutSkills : "" }</p>
  				<c:forEach items="${resumeModel.resumeSkillList}" var="skillsItem">
		        	<H5>${skillsItem.skillType}</h5>
		        	<div class="progress">
					  <div id="progress1" class="progress-bar progress-bar-info" role="progressbar" aria-valuenow="${skillsItem.skillLevel*20}" aria-valuemin="0" aria-valuemax="100" style="width: ${skillsItem.skillLevel*20}%">
					    <span class="sr-only">${skillsItem.skillLevel*20}% Complete (success)</span>
					  </div>
					</div>
				</c:forEach>	
                
                <hr>
  			</div>
  			
  		</div>	
  	</div>
  	
  	<div class="col-md-2"></div>
  	
 
  </div>
</div>


   <!-- Portfolio Section
   ================================================== -->
   
<div class="container-fluid" >
  <div class="row"  >
  
   	<div class="col-md-2" ></div>
   	
  	<div class="col-md-8">
  		
  				
  				<blockquote class="blockquote-reverse">
				  <p>(Any quote you lie you can add)Your work is going to fill a large part of your life, and the only way to 
				     be truly satisfied is to do what you believe is great work. And the only 
				     way to do great work is to love what you do. If you haven't found it yet, 
				     keep looking. Don't settle. As with all matters of the heart, you'll know 
				     when you find it.</p>
				  <footer> <cite title="Source Title">Steve Jobs</cite></footer>
				</blockquote>
                
                <hr>
  		
  	</div>
  	
  	<div class="col-md-2"></div>
  	
 
  </div>
</div>


    <!-- Portfolio Section End-->
    
    
  <div class="container-fluid" >
  <div class="container">
  <h2 class="text-center"><span class="label label-success">CONTACT ME</span></h2>
			<div class="row">
				<div class="col-sm-6">
					<div class="footerWidget">
						<form>
		  				 	  <div class="form-group">
							    <label class="sr-only"  for="name">Name</label>
							    <input type="text" class="form-control" id="name"  placeholder="Name">
							  </div>
							  <div class="form-group">
							    <label class="sr-only"  for="email">Email address</label>
							    <input type="email" class="form-control" id="email"  placeholder="Email">
							  </div>
							  <div class="form-group">
							    <label class="sr-only"  for="subject">Subject</label>
							    <input type="text" class="form-control" id="subject" placeholder="Subject">
							  </div>
							  <div class="form-group">
							    <label class="sr-only"  for="message"></label>
							    <textarea class="form-control" rows="3" id="message" placeholder="Message"></textarea>
							  </div>
							  
							  <button type="submit" class="btn btn-default">Submit</button>
						</form>
						
					</div>
				</div>
				<div class="col-sm-3">
					<address>
					  <strong>Add Line1.</strong><br>
					  Line 2<br>
					  Line 3<br>
					  <abbr title="Phone">P:</abbr> (123) XXX-XXXX
					</address>
					
					<address>
					  <strong>Full Name</strong><br>
					  <a href="mailto:#">first.last@example.com</a>
					</address>
				</div>
					<div class="col-sm-3">   </div>
				</div>
			</div>
  	
  	<div class="col-md-2"></div>
  	
 
  </div>
</div>


   
   <!-- footer
   ================================================== -->
   <footer>

      <div class="row">

         <div class="twelve columns">
			<div class="container">
            <ul class="nav navbar-nav">
               <li><a href="#"><i class="fa fa-facebook"></i></a></li>
               <li><a href="#"><i class="fa fa-twitter"></i></a></li>
               <li><a href="#"><i class="fa fa-google-plus"></i></a></li>
               <li><a href="#"><i class="fa fa-linkedin"></i></a></li>
               <li><a href="#"><i class="fa fa-instagram"></i></a></li>
               <li><a href="#"><i class="fa fa-dribbble"></i></a></li>
               <li><a href="#"><i class="fa fa-skype"></i></a></li>
            </ul>
            </div>
            <div class="container">
			<ul class="list-unstyled">
			  <li>&copy; Copyright 2014 </li>
			  <li>Design by <a title="Styleshout" href="http://www.styleshout.com/">Prashant T</a></li>
			</ul>
	      </div>
            
         </div>

         <div id="go-top"><a class="smoothscroll" title="Back to Top" href="#home"><i class="icon-up-open"></i></a></div>

      </div>

   </footer> <!-- Footer End-->

