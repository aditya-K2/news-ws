package com.example.newsws;

import com.example.newsws.ApiClient.ApiResponse;
import com.example.newsws.ApiClient.Article;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class Page {
    static private String NavBar = """
	<div class="nav">
		<span class="space">
		News.
		</span>
		<div class="dropdown">
			<button class="dropbtn">
				=
				<div class="dropdown-content">
					<a href="http://localhost:10043/news_ws_war?country=in">in</a>
					<a href="http://localhost:10043/news_ws_war?country=us">us</a>
					<a href="http://localhost:10043/news_ws_war?country=au">au</a>
					<a href="http://localhost:10043/news_ws_war?country=fr">fr</a>
					<a href="http://localhost:10043/news_ws_war?country=rs">rs</a>
					<a href="http://localhost:10043/news_ws_war?country=ru">ru</a>
					<a href="http://localhost:10043/news_ws_war?country=jp">jp</a>
					<a href="http://localhost:10043/news_ws_war?country=us">us</a>
					<a href="http://localhost:10043/news_ws_war?country=nz">nz</a>
				</div>
				</button>
			<style>
				.nav {
					display: flex;
					width : 100%;
				}
				.space{
                    font-family: Montserrat;
                    font-style: Bold;
                    font-size : 44px;
                    color : #262626;
					flex: 8;
					width : 70%;
					margin-left : 30px;
				}
				.dropbtn {
				  flex : 1;
				  background-color: #c4c4c4;
				  color: white;
				  padding: 16px;
				  font-size: 16px;
				  border: none;
				  margin-right: 180px;
				  border-radius: 10px;
				  width: 60px;
				}
				.dropdown {
				  position: relative;
				  display: inline-block;
				}
				.dropdown-content {
				  overflow: auto;
				  overflow-y: :scroll;
				  display: none;
				  position: absolute;
				  background-color: #f1f1f1;
				  min-width: 160px;
				  box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
				  z-index: 1;
				}
				.dropdown-content a {
				  color: black;
				  padding: 12px 16px;
				  text-decoration: none;
				  display: block;
				}
				.dropdown-content a:hover {background-color: #ddd;}
				.dropdown:hover .dropdown-content {display: block;}
				.dropdown:hover .dropbtn {background-color: #a6a6a6;}
			</style>
		</div>
	</div>
    """;
    static private String StyleString =  """
                <style>
                    body {
                        background: #D8D8D8;
                        display: flex;
                        align-items : center;
                        justify-content : center;
                        flex-direction : column;
                        padding: 100px;
                        padding-top : 10px;
                    }
                    .glass {
                        width : 40px;
                        height : 40px;
                        transition: all 200ms ease;
                    }
                    .glass:hover{
                        fill : #000000;
                    }
                    .image {
                        flex : 1;
                    }
                    .titleDescription{
                        font-family: Poppins;
                        font-style: normal;
                        text-align : center;
                        font-size : 13px;
                        flex : 2;
                    }
                    h1 {
                        margin-top : 30px;
                        margin-bottom : 10px;
                    }
                    h3 {
                        font-style : italic;
                        font-weight: 10;
                        margin : 5px;
                        margin-top : 25px;
                    }
                    .searchBar{
                        width : 800px;
                        background : #F2F2F2;
                        border-radius : 5px;
                        padding-top : 0px;
                        padding-bottom : 0px;
                        display : flex;
                        margin : 20px;
                        width : 900px;
                    }
                    .submit {
                        background : #F2F2F2;
                        border-width : 0px;
                        width : 30px;
                        height : 30px;
                        border-radius : 5px;
                        margin-top : 5px;
                        flex : 1;
                    }
                    .searchQuery{
                        outline :none;
                        background : #F2F2F2;
                        border-width : 0px;
                        border-radius : 5px;
                        margin-bottom : 8px;
                        flex : 8;
                        font-family: IBM Plex Mono;
                        font-style: normal;
                        font-weight: normal;
                        font-size: 30px;
                        line-height: 47px;
                        text-align: center;
                        color: #A0A0A0;
                    }
                    .search {
                        display: flex;
                        padding : 0px;
                    }
                    .newsCard {
                        padding : 10px;
                        margin : 10px;
                        display : flex;
                        border-radius : 10px;
                        background : #F2F2F2 ;
                        max-width : 900px;
                        transition: all 300ms ease;
                    }
                    img {
                        max-width : 40%;
                        margin: 20px;
                        margin-left : 10px;
                        border-radius : 10px;
                    }
                    a {
                        color : inherit;
                        text-decoration: none;
                    }
                    .newsCard:hover {
                        box-shadow : 0px 5px 4px 3px #888888 ;
                    }
                </style>
            """;

    static private String HtmlString = """ 
                <html lang="en">
                <head>
                    <meta charset="UTF-8">
                    <title></title>
                </head>
                <meta>
                    <link rel="preconnect" href="https://fonts.googleapis.com">
					<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
					<link href="https://fonts.googleapis.com/css2?family=IBM+Plex+Mono&family=Montserrat:wght@500&family=Noto+Sans+JP&family=Poppins&display=swap" rel="stylesheet">
                </meta>
                <body>
                """ ;

    static private String ScriptTag = """
	<script>
		function searchFor(){
					window.open("http://localhost:10043/news_ws_war/search?query=" + document.getElementsByClassName("searchQuery")[0].value.replace(" ", "+"), "_self");
		}
	</script>
	""";

    static private String SearchBarDiv = """ 
	<div class="searchBar">
		<input class="searchQuery" type="text", name="search">
		<button class="submit" onclick="searchFor()">
			<svg class="glass" fill="#afafaf" xmlns="http://www.w3.org/2000/svg"  viewBox="0 0 30 30"><path d="M 13 3 C 7.4889971 3 3 7.4889971 3 13 C 3 18.511003 7.4889971 23 13 23 C 15.396508 23 17.597385 22.148986 19.322266 20.736328 L 25.292969 26.707031 A 1.0001 1.0001 0 1 0 26.707031 25.292969 L 20.736328 19.322266 C 22.148986 17.597385 23 15.396508 23 13 C 23 7.4889971 18.511003 3 13 3 z M 13 5 C 17.430123 5 21 8.5698774 21 13 C 21 17.430123 17.430123 21 13 21 C 8.5698774 21 5 17.430123 5 13 C 5 8.5698774 8.5698774 5 13 5 z"/>
			</svg>
		</button>
	</div>
	""";

    public static void Respond(HttpServletResponse response, ApiResponse ab) throws IOException {
        PrintWriter out = response.getWriter();
        out.println(HtmlString);
        out.println(NavBar);
        out.println(StyleString);
        out.println(ScriptTag);
        out.println(SearchBarDiv);
        if ( ab != null ) {
            if ( ab.getArticles() != null ) {
                for (Article z : ab.getArticles()) {
                    out.println(z.GenerateDiv());
                }
            } else{
                out.println("<h1> No Articles Received </h1>");
            }
        } else {
            out.println("<h1> No Response Received </h1>" + "<h1> " + ab.getStatus() + "</h1>");
        }
        out.println("</body></html>");
    }
}
