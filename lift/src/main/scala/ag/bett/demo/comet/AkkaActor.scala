/**
 * Copyright 2011 Franz Bettag <franz@bett.ag>
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *
 */

package ag.bett.demo.comet

import akka.actor._
import akka.actor.Actor._
import net.liftweb.util._

import ag.bett.demo.actor._


/* Local akka Actor (like LiftActor) */
object LADemoAkkaActor {
    lazy val actor = actorOf[LADemoAkkaActorService].start

}


/* Remote Actor */
object LADemoAkkaRemoteActor {
    val actorHost = Props.get("akka.remote.host") openOr("127.0.0.1")
    val actorPort = Props.get("akka.remote.port").openOr("2552").toInt

    lazy val actor = remote.actorFor("lift-akka-example-service", actorHost, actorPort)

}
