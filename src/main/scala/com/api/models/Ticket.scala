package com.api.models

class Ticket (Id : String, Lines : Array[Line]){

  private var _id = Id
  private var _lines = Lines

  def id = _id
  def lines = _lines

}
