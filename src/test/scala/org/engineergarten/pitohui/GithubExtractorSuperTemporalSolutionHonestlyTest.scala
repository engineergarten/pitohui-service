package org.engineergarten.pitohui

import monix.eval.Task
import org.engineergarten.pitohui.GithubExtractor.{GithubProject, GithubProjectContent}
import org.scalatest.flatspec.AnyFlatSpec

class GithubExtractorSuperTemporalSolutionHonestlyTest extends AnyFlatSpec {

  val githubExtractor = new GithubExtractorSuperTemporalSolutionHonestly[Task]("")

  "github extractor" should "split project files from json" in {
    val jstr =
      """{
        |    "data": {
        |        "content": {
        |            "nameWithOwner": "engineergarten/pitohui",
        |            "createdAt": "2020-02-10T07:02:33Z",
        |            "description": "Board of ideas, projects and a place to search collaboration",
        |            "diskUsage": 8,
        |            "object": {
        |                "entries": [
        |                    {
        |                        "name": "20200111_pitohui.md",
        |                        "object": {
        |                            "id": "MDQ6QmxvYjIzOTQ0ODI4NDpiOTRhM2M0YjRmNDk4ZWUzY2E5ZTM1Y2EwOWJhMzM1MThkZmM0MjIz",
        |                            "text": "#  Title\nPitohui\n\n## Status\n**active**\n\n## Tags\nnon-commercial, open source, service, social\n\n## Description\nThis project dedicated to young specialists who want to have some practices in software development in technologies they wonder, or who want to build own team and create something incredible (or typical)\n\n[Short specification and roadmap](https://docs.google.com/document/d/1F9Sa1SfuEUW8mstn5dsU2cC4ZCuSgIVEyY82M34DyMg)\n\n## Dates\nCreated at Feb 11, 2020\n\n## Links\n[pitohui official site](https://github.com/engineergarten/pitohui)\n\n## Team\n[Github](https://github.com/orgs/engineergarten/people)\nContacts: \n- https://t.me/NotYoursBartosso\n- https://t.me/optician_owl\n\n## Analogs and inspirations\nWithout research [/shrug]\n\n## Tech stack and other interesting info about project daily routine\nScala, Tofu.\nIt’s a beginning. Only backend lang is set (most comfortable for founders).\n\n## Looking for\n* Developers with any skills.\n* Site and logo designer.\n"
        |                        }
        |                    },
        |                    {
        |                        "name": "README.md",
        |                        "object": {
        |                            "id": "MDQ6QmxvYjIzOTQ0ODI4NDpmZmQ5MzI1MTliNTMwMzMzMGQwODE0MTQ3NDNiOGRjMGExZDM0NmZh",
        |                            "text": "# About\nThis project dedicated to young specialists who want to have some practices in software development in technologies they wonder, or who want to build own team and create something incredible (or typical) \n# Add project or idea\n1. Write a markdown file with a project or idea description following template.\n2. Name file like `yyyyMMdd_${name}.md` (sorry for manual indexing).\n3. Create a pull request to master. \n# Template\n\n```markdown\n#  Title\nYenisei\n\n## Status\n**idea**/**active**/**finished**\n\n## Tags\n(commercial/non-commercial), (open source/closed source), library, any, other, tag, comma separated\n\n## Description\nSpear and Harmonic Multiplicational Class composition syntax helper\n\n## Dates\nCreated at Apr 6, 2019\n\n## Links\n[yenisei source code](https://github.com/travel-integrator/yenisei)\n[yenisei official site](https://yenisei.dev)\n\n## Team\n[Github](https://github.com/travel-integrator)\nContacts: \n- https://twitter.com/kirillschallopooghin\n- https://twitter.com/rectbraket\n\n## Analogs and inspirations\nArrows theory and [Volga library](https://github.com/manatki/volga)\n\n## Tech stack and other interesting info about project daily routine\nJavascipt, angular, golang, mongodb, perl6, php, docker, yaml, spring-boot.\n\n## Looking for\n* Backend developers of any level \n* Site designer \n* Salesman with government experience.\n* Github devops\n```\n"
        |                        }
        |                    }
        |                ]
        |            }
        |        }
        |    }
        |}
        |""".stripMargin

    val result = Set(
      GithubProject(
        "20200111_pitohui.md",
        GithubProjectContent(
          "#  Title\nPitohui\n\n## Status\n**active**\n\n## Tags\nnon-commercial, open source, service, social\n\n## Description\nThis project dedicated to young specialists who want to have some practices in software development in technologies they wonder, or who want to build own team and create something incredible (or typical)\n\n[Short specification and roadmap](https://docs.google.com/document/d/1F9Sa1SfuEUW8mstn5dsU2cC4ZCuSgIVEyY82M34DyMg)\n\n## Dates\nCreated at Feb 11, 2020\n\n## Links\n[pitohui official site](https://github.com/engineergarten/pitohui)\n\n## Team\n[Github](https://github.com/orgs/engineergarten/people)\nContacts: \n- https://t.me/NotYoursBartosso\n- https://t.me/optician_owl\n\n## Analogs and inspirations\nWithout research [/shrug]\n\n## Tech stack and other interesting info about project daily routine\nScala, Tofu.\nIt’s a beginning. Only backend lang is set (most comfortable for founders).\n\n## Looking for\n* Developers with any skills.\n* Site and logo designer.\n"
        )
      ),
      GithubProject(
        "README.md",
        GithubProjectContent(
          "# About\nThis project dedicated to young specialists who want to have some practices in software development in technologies they wonder, or who want to build own team and create something incredible (or typical) \n# Add project or idea\n1. Write a markdown file with a project or idea description following template.\n2. Name file like `yyyyMMdd_${name}.md` (sorry for manual indexing).\n3. Create a pull request to master. \n# Template\n\n```markdown\n#  Title\nYenisei\n\n## Status\n**idea**/**active**/**finished**\n\n## Tags\n(commercial/non-commercial), (open source/closed source), library, any, other, tag, comma separated\n\n## Description\nSpear and Harmonic Multiplicational Class composition syntax helper\n\n## Dates\nCreated at Apr 6, 2019\n\n## Links\n[yenisei source code](https://github.com/travel-integrator/yenisei)\n[yenisei official site](https://yenisei.dev)\n\n## Team\n[Github](https://github.com/travel-integrator)\nContacts: \n- https://twitter.com/kirillschallopooghin\n- https://twitter.com/rectbraket\n\n## Analogs and inspirations\nArrows theory and [Volga library](https://github.com/manatki/volga)\n\n## Tech stack and other interesting info about project daily routine\nJavascipt, angular, golang, mongodb, perl6, php, docker, yaml, spring-boot.\n\n## Looking for\n* Backend developers of any level \n* Site designer \n* Salesman with government experience.\n* Github devops\n```\n"
        )
      )
    )

    assert(githubExtractor.splitFiles(jstr).map(_.toSet) === Right(result))
  }
}
