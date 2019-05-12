package rest;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import domain.services.MovieService;
import domain.Comment;
import domain.Movie;

@Path("/movies")
public class MovieResources {

	private MovieService db = new MovieService();
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Movie> getAll()
	{
		return db.getAll();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response Add(Movie movie) {
		db.add(movie);
		return Response.ok(movie.getId()).build();
	}
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response get(@PathParam("id") int id) {
		Movie result = db.get(id);
		if(result==null) {
			return Response.status(404).build();
		}
		return Response.ok(result).build();
	}
	
	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response update(@PathParam("id") int id, Movie m) {
		Movie result = db.get(id);
		if(result == null)
			return Response.status(404).build();
		m.setId(id);
		db.update(m);
		return Response.ok().build();
	}
	
	@DELETE
	@Path("/{id}")
	public Response delete(@PathParam("id") int id) {
		Movie result = db.get(id);
		if(result == null)
			return Response.status(404).build();
		db.delete(result);
		return Response.ok().build();
	}
	
	@GET
	@Path("/{movieId}/comments")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Comment> getComments(@PathParam("movieId") int movieId){
		Movie result = db.get(movieId);
		if(result == null)
			return null;
		if(result.getComment()==null)
			result.setComment(new ArrayList<Comment>());
		return result.getComment();
	}
	
	@POST
	@Path("/{Id}/comments")
	@Produces(MediaType.APPLICATION_JSON)
	public Response addComment(@PathParam("Id") int movieId, Comment comment){
		Movie result = db.get(movieId);
		if(result == null)
			return null;
		if(result.getComment()==null)
			result.setComment(new ArrayList<Comment>());
		result.getComment().add(comment);
		return Response.ok().build();
	}
	
	@POST
	@Path("/{Id}/{grade}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response addGrade(@PathParam("Id") int movieId,@PathParam("grade") int grade){
		Movie result = db.get(movieId);
		if(result == null)
			return null;
		result.addGrade(grade);
		return Response.ok().build();
	}
	
	@GET
	@Path("/{Id}/grade")
	public float Grade(@PathParam("id")int movieId) {
		Movie result = db.get(movieId);
		if(result == null)
			return 404;
		return result.getGrade();
	}
	
	
//	@DELETE
//	@Path("/{movieId}/comments/{commentId}")
//	public Response deleteComment(
//			@PathParam("movieId") int movieId,
//			@PathParam("commentId") int commentId)
//	{
//		Movie result = db.get(movieId);
//		if(result == null)
//			return Response.status(404).build();
//		if(result.getComment(commentId)== null)
//		
//		return Response.ok().build();
//	}
}
