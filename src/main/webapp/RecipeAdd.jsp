<%-- 
    Document   : index
    Created on : 15-Apr-2015, 8:26:33 PM
    Author     : c0641046
--%>

<!doctype html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <meta name="description" content="Beryl Recipe Blog">
        <meta name="author" content="Beryl Nene">


        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">

        <!-- Optional theme -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css">
        <script src="https://code.jquery.com/jquery-1.9.1.js"></script>

        <!-- Latest compiled and minified JavaScript -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
        <script src="https://code.jquery.com/jquery-1.10.2.js"></script>  


        <title>Beryl's Recipe Blog</title>
        <style>

            body {
                margin-top: 75px;
                 background-image: url("images/main1.jpg"); 
                
                 font-weight: bold;
                 font-size: 160%
            }


            footer {
                margin: 10px 0;
            }

            #comments, #comments li {
                margin: 0;
                padding: 0;
            }

            #comments li {
                list-style: none;
            }

            .photo {
                margin-bottom: 10px;
            }

            .social-buttons button {
                margin-top: 5px;
            }
            footer {
                font-size: 80%;
                text-align: center;
                background-color: #191919;
                border: 2px solid;
                padding: 2em;
                clear: both;
                color: #808080;
                    }
                   
                    

        </style>
        <script>
            $(document).ready(function() {
            $('#addRecipeButton').click(function () {
            alert("okay");
                    $.ajax({
                    type: "POST",
                            url: "rs/recipe",
                            contentType: "application/json",
                            dataType: "json",
                            data : JSON.stringify({
                                "email": $("#email").val(),
                                "author": $("#author").val(),
                                "category":$("#category").val(),
                                "recipeName": $("#recipeName").val(),
                                "ingredient":$("#ingredients").val(),
                                "step": $("#steps").val(),
                                "dateCreated": $("#dateCreated").val()
                            }),
                            success: function(data) {
                                   location.href = "http://localhost:8080/recipeblog/index.html";
                            }

                    });
                });
            });
        </script>
    <body>


        <!-- Header -->
        <header class="navbar navbar-inverse navbar-fixed-top bs-docs-nav" role="banner">			
            <div class="container">
                <div class="navbar-header">
                    <button class="navbar-toggle" type="button" data-toggle="collapse" data-target=".bs-navbar-collapse">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a href="index.html" class="navbar-brand">Beryl Recipe Blog</a>
                </div>
                <nav class="collapse navbar-collapse bs-navbar-collapse" role="navigation">
                    <form class="navbar-form navbar-right" role="search">
                        <div class="form-group">
                          
                    <ul class="nav navbar-nav">
                        <li> <a href="index.html">Home</a></li>
                        <li  class="active"><a href="RecipeAdd">Add Recipe</a></li>
                        <li><a href="about.html">About</a></li>
                    </ul>
                </nav>
            </div>
        </header>


        <div class="container">
            <div class="contact-form">
                <form id="form" class="form-horizontal col-md-8" role="form" action = "index.html" method="POST">

                    
                    <div class="form-group">
                        <label for="email" class="col-md-2">Email</label>
                        <div class="col-md-10">
                            <input type="email" class="form-control" id="email" placeholder="Email"><br>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="author" class="col-md-2">Author</label>
                        <div class="col-md-10">
                            <input type="text" class="form-control" id="author" placeholder="Author"><br>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="category" class="col-md-2">Category</label>
                        <div class="col-md-10">
                           <select class="form-control" id="category" placeholder="Category">
                               
                               <option> UnKnown Category </option>
                               <option>Appetizers  </option>
                               <option>Beverages (non alcoholic)  </option>
                               <option> Breads </option>
                               <option> Breakfast & Brunch </option>
                               <option> Condiments</option>
                               <option>Desserts</option>
                               <option>Drinks / Cocktails</option>
                               <option>Grilling</option>
                               <option>International Cuisine</option>
                               <option>Kid Friendly Recipes</option>
                               <option>Main Dishes</option>
                               <option>Salads </option>
                               <option>Sandwiches</option>
                               <option>Sauces and Marinades  </option>
                               <option>Side Dishes</option>
                               <option>Slow Cooker Recipes</option>
                               <option>Snacks</option>
                               <option>Soup Recipes</option>
                               <option>Others</option>
                           </select><br>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="recipeName" class="col-md-2">Recipe Name</label>
                        <div class="col-md-10">
                            <input type="text" class="form-control" id="recipeName" placeholder="Recipe Name"><br>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="ingredients" class="col-md-2">Ingredients</label>
                        <div class="col-md-10">
                            <textarea class="form-control" id="ingredients" placeholder="Ingredients, Use numbers and commas to differentiate different ingredients"></textarea><br>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="steps" class="col-md-2">Steps</label>
                        <div class="col-md-10">
                            <textarea class="form-control" id="steps" placeholder="Steps, Use numbers and commas to differentiate different steps"></textarea><br>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="dateCreated" class="col-md-2">Date Created</label>
                        <div class="col-md-10">
                            <input type="date" class="form-control" id="dateCreated"><br>
                        </div>
                    </div>

                    <div class="form-group">
                        <div class="col-md-12 text-right">
                            <button type="reset" class="btn btn-lg btn-primary"   id="cancel">Cancel</button>
                            <input type="button" class="btn btn-lg btn-primary" id="addRecipeButton" value="Post">
                            
                        </div>

                      
                    </div>
                    
                </form>	
            </div>
        </div>

<footer data-role="footer">
        	<h4>All Rights Reserved</h4>
			<h4>&copy Beryl Bawo Nene 2015 </h4>
    	</footer>
   
    </body>
</html>
