package com.example.memorygame.architechture.threading

import io.reactivex.Scheduler

interface SchedulersProvider {
  val io: Scheduler
  val computation: Scheduler
  val ui: Scheduler
}
