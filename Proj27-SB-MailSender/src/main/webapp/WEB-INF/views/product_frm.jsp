<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
 <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Product-Form</title>
</head>
<body>
 <div align="center">
  <h1>Product Booking Form</h1>
  <!-- 
  to read the form data by clicking save button as a email
   -->
  <form:form action="/prod/save" method="post" modelAttribute="product"  enctype="multipart/form-data">
   <table style="with: 80%">
    <tr>
     <td>Product Name</td>
     <td><form:input path="prodName"/></td>
    </tr>
    <tr>
     <td>Product Cost</td>
        <td><form:input path="prodCost"/></td>
    </tr>
    <tr>
     <td>GST</td>
     <td><form:select path="gst">
     <form:option value="5">5%-SLAB</form:option>
     <form:option value="10">10%-SLAB</form:option>
     <form:option value="15">15%-SLAB</form:option>
     <form:option value="25">20%-SLAB</form:option>
     <form:option value="30">25%-SLAB</form:option>
     </form:select></td>
    </tr>
    <tr>
     <td>Note</td>
     <td><form:textarea path="note"/></td>
    </tr>
    <tr>
     <td>Email</td>
     <td><form:input path="email" /></td>
    </tr>
    <%--  <form:input type="file" class="filestyle" path="studentPhoto"
                                    id="studentPhoto" placeholder="Upload Photo"
                                    required="required" /> --%>
                                   upload document:: <form:input type="file"  path="fileOb"
                                    placeholder="Upload Photo"
                                    required="required" />
    <!-- <tr>
    <div class="form-group ">
                                <label for="photo">Photo:</label>
                                <form:input type="file" class="filestyle" path="studentPhoto"
                                    id="studentPhoto" placeholder="Upload Photo"
                                    required="required" />
                            </div>
     <td>upload document</td>
     <td><input type="file"  name="fileOb"/></td>
    </tr> -->
    <tr>
     <td>Address</td>
     <td><form:input path="address" /></td>
    </tr>
    <tr>
     <td>Contact No</td>
     <td><form:input path="contact" /></td>
    </tr>
   </table>
   <input type="submit" value="add to cart" />
  </form:form>
 </div>
</body>
${successMsg}
</html>