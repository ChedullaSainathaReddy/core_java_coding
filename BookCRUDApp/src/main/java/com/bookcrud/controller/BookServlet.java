package com.bookcrud.controller;

import com.bookcrud.dao.BookDao;
import com.bookcrud.model.Book;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/books")
public class BookServlet extends HttpServlet {
    private BookDao bookDAO;

    public void init() {
        bookDAO = new BookDao();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        try {
            switch (action == null ? "list" : action) {
                case "new": showForm(request, response, null); break;
                case "edit": showForm(request, response, Integer.parseInt(request.getParameter("id"))); break;
                case "delete": deleteBook(request, response); break;
                default: listBooks(request, response); break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String idStr = request.getParameter("id");
        String title = request.getParameter("title");
        String author = request.getParameter("author");

        Book book = new Book(idStr == null || idStr.isEmpty() ? 0 : Integer.parseInt(idStr), title, author);

        try {
            if (book.getId() == 0) {
                bookDAO.insertBook(book);
            } else {
                bookDAO.updateBook(book);
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
        response.sendRedirect("books");
    }

    private void listBooks(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        List<Book> books = bookDAO.listAllBooks();
        request.setAttribute("books", books);
        RequestDispatcher dispatcher = request.getRequestDispatcher("list.jsp");
        dispatcher.forward(request, response);
    }

    private void showForm(HttpServletRequest request, HttpServletResponse response, Integer id) throws ServletException, IOException, SQLException {
        if (id != null) {
            Book book = bookDAO.getBook(id);
            request.setAttribute("book", book);
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("form.jsp");
        dispatcher.forward(request, response);
    }

    private void deleteBook(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        bookDAO.deleteBook(id);
        response.sendRedirect("books");
    }
}