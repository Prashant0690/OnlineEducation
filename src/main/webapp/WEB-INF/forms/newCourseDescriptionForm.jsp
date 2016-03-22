<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../footer/taglib.jsp"%>

<script type="text/javascript" src="http://js.nicedit.com/nicEdit-latest.js"></script> <script type="text/javascript">
//<![CDATA[
        bkLib.onDomLoaded(function() { nicEditors.allTextAreas() });
  //]]>
 </script>


		 <form:form class="form-horizontal" commandName="courseDescriptionData">
		 		<%-- <form:errors path="*" /> --%>
					
					<div class="form-group" disabled>
						<label for="descType" class="col-sm-4 control-label">Description Type</label>
						<div class="col-sm-8"> ${courseDescriptionData.descType}
							<form:hidden  path="descType" class="form-control" id="descType"
								placeholder="descType"   />
						</div>
					</div>
					
					<div class="form-group">
						<label for="descString" class="col-sm-4 control-label">Description</label>
						<div class="col-sm-8">
							<form:textarea path="descString" class="form-control" id="descString" rows="7" />
							<form:errors path="descString" />
						</div>
					</div>

				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-8">
						<button type="submit" class="btn btn-default">ADD/UPDATE DESCRIPTION</button>
					</div>
				</div>
			</form:form>
