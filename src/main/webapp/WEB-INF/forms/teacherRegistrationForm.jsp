<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../footer/taglib.jsp"%>

<div class="alert alert-success">${beforeAuthenticationCmt} </div>

<div class="container">
<div class="row">
  	<div class="col-md-2"></div>
  	
  	<div class="col-md-8">
		 <form:form class="form-horizontal" commandName="teacherData">
		 		<form:errors path="*" class="alert alert-danger"/>
					<div class="form-group">
						<label for="uid" class="col-sm-4 control-label">UID</label>
						<div class="col-sm-8">
							<form:input path="teacherUID" class="form-control" id="uid"
								placeholder="UID" />
						</div>
					</div>
					
					<div class="form-group">
						<label for="currentlyWorkingWith" class="col-sm-4 control-label">Currently Working With</label>
						<div class="col-sm-8">
							<form:input path="teachersPresentWork" class="form-control" id="currentlyWorkingWith"
								placeholder="" />
						</div>
					</div>
					
				<%-- 	<div class="form-group">
						<label for="name" class="col-sm-4 control-label">Name</label>
						<div class="col-sm-8">
							<form:input path="" class="form-control" id="name"
								placeholder="Full Name" />
						</div>
					</div> --%>
					
					<div class="form-group">
						<label for="dateOfBirth" class="col-sm-4 control-label">DOB</label>
						<div class="col-sm-8">
							<form:input path="teacherDOB" class="form-control" id="dateOfBirth"
								placeholder="Date Of Birth" />
						</div>
					</div>
					
					<div class="form-group">
						<label for="male" class="col-sm-4 control-label">Sex</label>
						<form:radiobuttons path="teacherSex" class="radio-inline" items="${sexOptions}" />
					</div>

					<!-- <div class="form-group">
						<label for="uploadphoto" class="col-sm-4 control-label">Upload Photo</label> <input
							type="file" id="uploadphoto">
						<p class="help-block">Upload a latest photo</p>
					</div> -->
					
					<div class="form-group">
						<label for="permanentAddress" class="col-sm-4 control-label">Permanent Address</label>
						<div class="col-sm-8">
							<form:textarea path="teacherPermanentAddress" class="form-control" id="permanentAddress" rows="3" />
						</div>
					</div>
					
					<div class="form-group">
						<label for="currentAddress" class="col-sm-4 control-label">Current Address</label>
						<div class="col-sm-8">
							<form:textarea path="teacherCurrentAddress" class="form-control" id="currentAddress" rows="3" />
						</div>
					</div>
					
					<div class="form-group">
						<label for="inputEmail3" class="col-sm-4 control-label">Email</label>
						<div class="col-sm-8">
							<form:input path="teacherEmail" class="form-control" id="inputEmail3"
								placeholder="Email" />
						</div>
					</div>
					
					<div class="form-group">
						<label for="number" class="col-sm-4 control-label">Number</label>
						<div class="col-sm-8">
							<form:input path="teacherPhoneNo" class="form-control" id="number"
								placeholder="Mobile Number" />
						</div>
					</div>
					
					<!-- <div class="form-group">
						<label for="uploadDoc" class="col-sm-4 control-label">Upload Document</label> <input
							type="file" id="uploadDoc">
						<p class="help-block">Upload any id proof .</p>
					</div> -->


				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-8">
						<button type="submit" class="btn btn-default">UPDATE DETAILS</button>
					</div>
				</div>
			</form:form>
	</div>
	
	<div class="col-md-2"></div>
</div>
</div>