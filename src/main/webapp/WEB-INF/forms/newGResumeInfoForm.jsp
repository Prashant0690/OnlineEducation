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

		 <form:form class="form-horizontal" commandName="gResumeInfoData">
		 		<%-- <form:errors path="*" /> --%>
		 		
		 			<div class="form-group">
						<label for="infoType" class="col-sm-4 control-label">Type</label>
						<div class="col-sm-8">
							<form:select path="infoType" class="form-control" id="infoType">
					            <form:option value="Work" label="Work" />
					            <form:option value="Education" label="Education" />
					        </form:select>
							<form:errors path="infoType" />
						</div>
					</div>
					
					<div class="form-group">
						<label for=infoLine1 class="col-sm-4 control-label">Line 1</label>
						<div class="col-sm-8">
							<form:input path="infoLine1" class="form-control" id="infoLine1"
								placeholder="Where You worked Or what you Studied" aria-describedby="helpBlockLine1"/>
							<span id="helpBlockLine1" class="help-block">
							What  you studied eg Bachelor Of Science in Computer Science Or
							Where you worked eg: Tata Moters.
							</span>
							<form:errors path="infoLine1" />
						</div>
					</div>
					
					<div class="form-group">
						<label for=infoLine2 class="col-sm-4 control-label">Line 2</label>
						<div class="col-sm-8">
							<form:input path="infoLine2" class="form-control" id="infoLine2"
								placeholder="" aria-describedby="helpBlockLine2"/>
							<span id="helpBlockLine2" class="help-block">
							What  you studied eg IIT, Kanpur - UP Or
							What was you post eg: Senior System Engg.
							</span>
							<form:errors path="infoLine2" />
						</div>
					</div>
					
					<div class="form-group">
						<label for=infoPeriod class="col-sm-4 control-label">Line 2</label>
						<div class="col-sm-8">
							<form:input path="infoPeriod" class="form-control" id="infoPeriod"
								placeholder="Duration" aria-describedby="helpBlockInfoPeriod"/>
							<span id="helpBlockInfoPeriod" class="help-block">
							format: March 2007 - April 2011 or March 2010 - Present
							</span>
							<form:errors path="infoPeriod" />
						</div>
					</div>
					
					<div class="form-group">
						<label for=infoContent class="col-sm-4 control-label">Content</label>
						<div class="col-sm-8">
							<form:input path="infoContent" class="form-control" id="infoContent"
								placeholder="Duration" aria-describedby="helpBlockInfoContent"/>
							<span id="helpBlockInfoContent" class="help-block">
							A little description related to your Education or job if you like
							</span>
							<form:errors path="infoPeriod" />
						</div>
					</div>
					
					
					
					

				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-8">
						<button type="submit" class="btn btn-default">ADD/UPDATE MAGAZINE</button>
					</div>
				</div>
			</form:form>
