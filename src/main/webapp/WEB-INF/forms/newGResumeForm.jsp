<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../footer/taglib.jsp"%>

<!-- <script type="text/javascript" src="http://js.nicedit.com/nicEdit-latest.js"></script> <script type="text/javascript">
//<![CDATA[
        bkLib.onDomLoaded(function() { nicEditors.allTextAreas() });
  //]]>
 </script>
 <script>
  $(function() {
    $( "#dispatchedDate" ).datepicker({
    	dateFormat: "yy/mm/dd"
    });
  });
 </script> -->

		 <form:form class="form-horizontal" commandName="gResumeData">
		 		<%-- <form:errors path="*" /> --%>
					
					<div class="form-group">
						<label for="yourName" class="col-sm-4 control-label">yourName</label>
						<div class="col-sm-8">
							<form:input path="yourName" class="form-control" id="yourName"
								placeholder="Title" aria-describedby="helpBlockYourName" />
								<span id="helpBlockYourName" class="help-block">Name at the top example I'm John doe Or John Doe</span>
							<form:errors path="yourName" />
						</div>
					</div>
					
					<div class="form-group">
						<label for="yourOpeningCmt" class="col-sm-4 control-label">Opening Comment</label>
						<div class="col-sm-8">
							<form:input path="yourOpeningCmt" class="form-control" id="yourOpeningCmt"
								  aria-describedby="helpBlockOpeningCmt"/>
								  <span id="helpBlockYourName" class="help-block"></span>
							<form:errors path="yourOpeningCmt" />
						</div>
					</div>
					
					<div class="form-group">
						<label for="aboutMe" class="col-sm-4 control-label">About Me</label>
						<div class="col-sm-8">
							<form:textarea path="aboutMe" class="form-control" id="aboutMe" rows="7" />
							<form:errors path="aboutMe" />
						</div>
					</div>
					
					<div class="form-group">
						<label for="aboutEducation" class="col-sm-4 control-label">About Education</label>
						<div class="col-sm-8">
							<form:textarea path="aboutEducation" class="form-control" id="aboutEducation" rows="7" />
							<form:errors path="aboutEducation" />
						</div>
					</div>
					
					<div class="form-group">
						<label for="aboutWork" class="col-sm-4 control-label">About Work</label>
						<div class="col-sm-8">
							<form:textarea path="aboutWork" class="form-control" id="aboutWork" rows="7" />
							<form:errors path="aboutWork" />
						</div>
					</div>
					
					<div class="form-group">
						<label for="aboutSkills" class="col-sm-4 control-label">About Skills</label>
						<div class="col-sm-8">
							<form:textarea path="aboutSkills" class="form-control" id="aboutSkills" rows="7" />
							<form:errors path="aboutSkills" />
						</div>
					</div>
					
					<div class="form-group">
						<label for="famousQuote" class="col-sm-4 control-label">Quote</label>
						<div class="col-sm-8">
							<form:textarea path="famousQuote" class="form-control" id="famousQuote" rows="7" />
							<form:errors path="famousQuote" />
						</div>
					</div>
					
					<div class="form-group">
						<label for="quoteBy" class="col-sm-4 control-label">Quote written bY</label>
						<div class="col-sm-8">
							<form:input path="quoteBy" class="form-control" id="quoteBy"
								placeholder="Title" />
							<form:errors path="quoteBy" />
						</div>
					</div>
					
					<div class="form-group">
						<label for="contactMe" class="col-sm-4 control-label">Contact You</label>
						<div class="col-sm-8">
							<form:input path="contactMe" class="form-control" id="contactMe"
								placeholder="Contact Me" aria-describedby="helpBlockContactMe" />
								
							<span id="helpBlockContactMe" class="help-block">
							Should be 5 line like (line1 , Line2 ,line3, Phone no Email)
							 each line Should be seperated by @#$% symbol
							 ex: line1 @#$% line2 @#$% line3 @#$% Moblie No. @#$% Email.
							</span>
							<form:errors path="contactMe" />
						</div>
					</div>
					

				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-8">
						<button type="submit" class="btn btn-default">ADD/UPDATE Resume</button>
					</div>
				</div>
			</form:form>
