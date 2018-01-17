package com.api

import io.finch.{Endpoint, Ok}
import io.finch.syntax._
import com.twitter.finagle.Http
import com.twitter.util.Await
import io.circe.generic.auto._
import io.finch.circe._

object Application extends App {

  val get_hello: Endpoint[String] = get("hello") { Ok("Get Hello!") }
  val post_hello: Endpoint[Int] = post("hello") { Ok(1000) }
  val put_hello: Endpoint[Boolean] = put("hello") {Ok(true)}
  val delete_hello: Endpoint[List[Char]] = delete("hello") {Ok(List('h','e','l','l','l','o'))}

  val api = (get_hello :+: post_hello :+: put_hello :+: delete_hello).toService
  val server = Http.server.serve(":8080", api)
  Await.ready(server)

}




