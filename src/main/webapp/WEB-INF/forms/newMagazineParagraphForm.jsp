<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../footer/taglib.jsp"%>

<script type="text/javascript" src="http://js.nicedit.com/nicEdit-latest.js"></script> <script type="text/javascript">
//<![CDATA[
        bkLib.onDomLoaded(function() { nicEditors.allTextAreas() });
  //]]>
 </script>


		 <form:form class="form-horizontal" commandName="magazineParagraphData">
		 		<%-- <form:errors path="*" /> --%>
					
					<%-- <div class="form-group">
						<label for="paraNo" class="col-sm-4 control-label">Paragraph Number</label>
						<form:select path="paraNo" class="form-control" items="${paraNumberOptions}" />
					</div> --%>
					
					<div class="form-group">
						<label for="paraContent" class="col-sm-4 control-label">Paragraph</label>
						<div class="col-sm-8">
							<form:textarea path="paraContent" class="form-control" id="paraContent" rows="7" />
							<form:errors path="paraContent" />
						</div>
					</div>

				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-8">
						<button type="submit" class="btn btn-default">ADD/UPDATE DESCRIPTION</button>
					</div>
				</div>
			</form:form>
