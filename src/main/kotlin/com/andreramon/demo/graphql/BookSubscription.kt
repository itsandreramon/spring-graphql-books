package com.andreramon.demo.graphql

import com.andreramon.demo.model.Book
import com.andreramon.demo.service.BookService
import com.expediagroup.graphql.annotations.GraphQLDescription
import com.expediagroup.graphql.spring.operations.Subscription
import org.springframework.stereotype.Component
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Component
class BookSubscription(
  private val bookService: BookService
) : Subscription {

  fun bookById(id: Int): Mono<Book> {
    return bookService.findBookById(id)
  }

  fun booksByAuthorId(id: Int): Flux<Book> {
    return bookService.findBooksByAuthorId(id)
  }

  fun allBooks(): Flux<Book> {
    return bookService.findAllBooks()
  }
}