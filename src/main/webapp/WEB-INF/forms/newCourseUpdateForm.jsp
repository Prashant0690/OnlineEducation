<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../footer/taglib.jsp"%>

<script type="text/javascript" src="http://js.nicedit.com/nicEdit-latest.js"></script> <script type="text/javascript">
//<![CDATA[
        bkLib.onDomLoaded(function() { nicEditors.allTextAreas() });
  //]]>
 </script>


		 <form:form class="form-horizontal" commandName="courseUpdateData">
		 		<%-- <form:errors path="*" /> --%>
					
					<div class="form-group">
						<label for="updateTitle" class="col-sm-4 control-label">yourName</label>
						<div class="col-sm-8">
							<form:input path="updateTitle" class="form-control" id="updateTitle"
								placeholder="Title"  />
							<form:errors path="updateTitle" />
						</div>
					</div>
					
					<div class="form-group">
						<label for="updateMessage" class="col-sm-4 control-label">Message</label>
						<div class="col-sm-8">
							<form:textarea path="updateMessage" class="form-control" id="updateMessage" rows="7" />
							<form:errors path="updateMessage" />
						</div>
					</div>

				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-8">
						<button type="submit" class="btn btn-default" >Post Update</button>
					</div>
				</div>
			</form:form>

			
			