package org.engineergarten.pitohui

import java.net.URI
import java.time.LocalDate

case class Project(
    name: String,
    status: Status,
    tags: List[Tag],
    description: String,
    createDttm: LocalDate,
    links: Set[URI],
    team: Set[Member],
    analogs: Set[Analog],
    techStack: String,
    lookingFor: List[Position]
)

case class Status()   // ToDo
case class Tag()      // Todo
case class Member()   // ToDo
case class Analog()   // ToDo
case class Position() // ToDo
