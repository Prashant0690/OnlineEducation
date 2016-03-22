<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../footer/taglib.jsp"%>

<script type="text/javascript" src="http://js.nicedit.com/nicEdit-latest.js"></script> <script type="text/javascript">
//<![CDATA[
        bkLib.onDomLoaded(function() { nicEditors.allTextAreas() });
  //]]>
 </script>


		<form:form class="form-horizontal" commandName="madazinePicUrlData">
		 		<%-- <form:errors path="*" /> --%>
					
					<div class="form-group">
						<label for="afterParaNo" class="col-sm-4 control-label">After Paragraph</label>
						<form:select path="afterParaNo" class="form-control" items="${afterParaNumeberrOptions}" />
					</div>
					
					<div class="form-group">
						<label for="picUrl" class="col-sm-4 control-label">PIC</label>
						<div class="col-sm-8">
							<form:input path="picUrl" class="form-control" id="picUrl"
								placeholder="" />
							<form:errors path="picUrl" />
						</div>
					</div>
					
					<div class="form-group">
						<label for="picName" class="col-sm-4 control-label">Pic Name</label>
						<div class="col-sm-8">
							<form:input path="picName" class="form-control" id="picName"
								placeholder="" />
							<form:errors path="picName" />
						</div>
					</div>

				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-8">
						<button type="submit" class="btn btn-default">ADD/UPDATE PIC</button>
					</div>
				</div>
			</form:form>
