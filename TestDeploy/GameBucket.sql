-- MySQL dump 10.13  Distrib 8.0.15, for Win64 (x86_64)
--
-- Host: localhost    Database: gamebucketdb
-- ------------------------------------------------------
-- Server version	8.0.13

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `games`
--

DROP TABLE IF EXISTS `games`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `games` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `title` varchar(40) NOT NULL,
  `releaseYear` year(4) NOT NULL,
  `description` text,
  `image` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `games`
--

LOCK TABLES `games` WRITE;
/*!40000 ALTER TABLE `games` DISABLE KEYS */;
INSERT INTO `games` VALUES (18,'Grand Theft Auto V',2013,'Grand Theft Auto V is a video \r\ngame \r\ndeveloped by Rockstar North. \r\nIt is the fifteenth instalment \r\nin the Grand Theft Auto series \r\nand the successor of Grand \r\nTheft Auto IV.','game18'),(19,'Grand Theft Auto IV',2008,'The very first dialogue by \r\nNiko in the very first trailer \r\nfor the game sets up the first \r\nnotable protagonist to be from \r\nanother country other than the \r\nUnited States, Niko Bellic, to \r\nenter the United States of \r\nAmerica and make more critical \r\nanalysis of American culture \r\nthan previous main characters \r\nhave done. Grand Theft Auto \r\nIV\'s deeper meaning circulates \r\naround Niko\'s own philosophy, \r\nand his clear, blunt critiques \r\nof American culture and life \r\nin general make the deeper \r\nideas much easier to see and \r\nunderstand. Niko is normally \r\nshown to be in the right, but \r\nis also proven to be overly \r\ncynical, leaving \r\ninterpretation open to the \r\nviewer.','game19'),(21,'Grand Theft Auto: San Andreas',2004,'Grand Theft Auto: San Andreas \r\nis a Rockstar North-developed \r\nvideo game, and is the seventh \r\ntitle in the Grand Theft Auto \r\nseries. It is the sequel to \r\nGrand Theft Auto: Vice City \r\nand the prequel to Grand Theft \r\nAuto: Liberty City Stories and \r\nGrand Theft Auto III. It was \r\nreleased on the same date as \r\nGrand Theft Auto Advance. GTA \r\nSan Andreas is set in the \r\nfictional state of San \r\nAndreas.','game21'),(23,'Battlefield 4',2013,'Battlefield 4 is a first-\r\nperson shooter video game \r\ndeveloped by video game \r\ndeveloper EA DICE and \r\npublished by Electronic Arts. \r\nIt is a sequel to 2011\'s \r\nBattlefield 3 and was released \r\nin October 2013 for Microsoft \r\nWindows, PlayStation 3, and \r\nXbox 360; then later in \r\nNovember for PlayStation 4 and \r\nXbox One.\r\n\r\nBattlefield 4 was met with \r\npositive reception. It was \r\npraised for its multiplayer \r\nmode, gameplay and graphics, \r\nbut was also criticized for \r\nits short and shallow single-\r\nplayer campaign mode, and for \r\nits numerous bugs and \r\nglitches. It was a commercial \r\nsuccess, selling over 7 \r\nmillion copies.','game23'),(24,'Battlefield 3',2011,'Battlefield 3 is a first-\r\nperson shooter video game \r\ndeveloped by EA DICE and \r\npublished by Electronic Arts. \r\nIt is a direct sequel to \r\n2005\'s Battlefield 2, and the \r\neleventh installment in the \r\nBattlefield franchise.','game24'),(26,'God of War',2018,'God of War[a] is an action-\r\nadventure video game developed \r\nby Santa Monica Studio and \r\npublished by Sony Interactive \r\nEntertainment (SIE). Released \r\non April 20, 2018, for the \r\nPlayStation 4 (PS4) console, \r\nit is the eighth installment \r\nin the God of War series, the \r\neighth chronologically, and \r\nthe sequel to 2010\'s God of \r\nWar III. Unlike previous \r\ngames, which were loosely \r\nbased on Greek mythology, this \r\ninstallment is loosely based \r\non Norse mythology, with the \r\nmajority of it set in ancient \r\nNorway in the realm of \r\nMidgard. For the first time in \r\nthe series, there are two main \r\nprotagonists: Kratos, the \r\nformer Greek God of War who \r\nremains as the only playable \r\ncharacter, and his young son \r\nAtreus; at times, the player \r\nmay passively control him. ','game26'),(27,'The Last of Us',2013,'The Last of Us is an action-\r\nadventure survival horror \r\nvideo game developed by \r\nNaughty Dog and published by \r\nSony Computer Entertainment. \r\nIt was released for the \r\nPlayStation 3 worldwide on \r\nJune 14, 2013. Players control \r\nJoel, a smuggler tasked with \r\nescorting a teenage girl, \r\nEllie, across a post-\r\napocalyptic United States. The \r\nLast of Us is played from a \r\nthird-person perspective. \r\nPlayers use firearms and \r\nimprovised weapons, and can \r\nuse stealth to defend against \r\nhostile humans and \r\ncannibalistic creatures \r\ninfected by a mutated strain \r\nof the Cordyceps fungus. In \r\nthe online multiplayer mode, \r\nup to eight players engage in \r\ncooperative and competitive \r\ngameplay.','game27'),(28,'Uncharted 4: A Thief\'s End',2014,'Uncharted 4: A Thief\'s End is \r\nan action-adventure game \r\ndeveloped by Naughty Dog and \r\npublished by Sony Computer \r\nEntertainment for PlayStation \r\n4 in May 2016. Following \r\nUncharted 3: Drake\'s \r\nDeception, it is the final \r\nUncharted game to feature \r\nprotagonist Nathan Drake \r\n(portrayed by Nolan North). \r\nDrake, retired from fortune \r\nhunting with his wife Elena, \r\nreunites with his estranged \r\nolder brother Sam and longtime \r\npartner Sully to search for \r\nCaptain Henry Avery\'s lost \r\ntreasure.','game28'),(29,'Uncharted: Drake\'s Fortune',2007,'Uncharted: Drake\'s Fortune is \r\nan action-adventure video game \r\ndeveloped by Naughty Dog and \r\npublished by Sony Computer \r\nEntertainment. It is the first \r\ngame in the Uncharted series, \r\nand was released in November \r\n2007 for PlayStation 3. The \r\nsingle-player story follows \r\nNathan Drake, the supposed \r\ndescendant of the explorer Sir \r\nFrancis Drake, as he seeks the \r\nlost treasure of El Dorado, \r\nwith the help of journalist \r\nElena Fisher and mentor Victor \r\nSullivan, whilst they battle a \r\nmercenary group led by Gabriel \r\nRoman.','game29'),(30,'Uncharted 2: Among Thieves',2009,'Uncharted 2: Among Thieves is \r\nan action-adventure video game \r\ndeveloped by Naughty Dog and \r\npublished by Sony Computer \r\nEntertainment. It is the \r\nsecond game in the Uncharted \r\nseries, and was released in \r\nOctober 2009 for PlayStation \r\n3. Set two years after the \r\nevents of Drake\'s Fortune, the \r\nsingle-player story follows \r\nNathan Drake, who partners \r\nChloe Frazer and Elena Fisher, \r\nas they search for the \r\nCintimani Stone and Shangri-\r\nLa, whilst battling a \r\nmercenary group led by Zoran \r\nLazareviÄ and old friend Harry \r\nFlynn.','game30'),(31,'Uncharted 3: Drake\'s Deception',2011,'Uncharted 3: Drake\'s Deception \r\nis an action-adventure video \r\ngame developed by Naughty Dog \r\nand published by Sony Computer \r\nEntertainment. It is third \r\ngame in the Uncharted series, \r\nand was released in November \r\n2011 for the PlayStation 3. \r\nThe single-player story \r\nfollows Nathan Drake, who \r\npartners his mentor Victor \r\nSullivan, as they search for \r\nthe legendary lost city the \r\nIram of the Pillars, whilst \r\nbattling a mercenary group led \r\nby Sullivan\'s former employer \r\nand romantic interest, \r\nKatherine Marlowe.','game31'),(32,'Horizon Zero Dawn',2017,'Horizon Zero Dawn is an action \r\nrole-playing game developed by \r\nGuerrilla Games and published \r\nby Sony Interactive \r\nEntertainment. It was released \r\nfor the PlayStation 4 in early \r\n2017. The plot follows Aloy, a \r\nhunter in a world overrun by \r\nmachines, who sets out to \r\nuncover her past. The player \r\nuses ranged weapons, a spear, \r\nand stealth to combat \r\nmechanised creatures and loot \r\ntheir remains. A skill tree \r\nprovides the player with new \r\nabilities and bonuses. The \r\nplayer can explore the open \r\nworld to discover side quests.','game32'),(33,'Bloodborne',2015,'Bloodborne[a] is an action \r\nrole-playing game developed by \r\nFromSoftware and published by \r\nSony Computer Entertainment \r\nfor the PlayStation 4, which \r\nreleased worldwide in March \r\n2015. Bloodborne follows the \r\nplayer character, the Hunter, \r\nthrough the decrepit Gothic, \r\nVictorian era-inspired city of \r\nYharnam, whose inhabitants \r\nhave been afflicted with an \r\nabnormal blood-borne disease, \r\nwith the player character \r\nunraveling the city\'s \r\nintriguing mysteries while \r\nfighting beasts, ultimately \r\nattempting to find the source \r\nof the plague and stop it.','game33'),(34,'The Witcher 3: Wild Hunt',2015,'The Witcher 3: Wild Hunt[a] is \r\na 2015 action role-playing \r\ngame developed and published \r\nby CD Projekt. Based on The \r\nWitcher series of fantasy \r\nnovels by Polish author \r\nAndrzej Sapkowski, it is the \r\nsequel to the 2011 game The \r\nWitcher 2: Assassins of Kings. \r\nPlayed in an open world with a \r\nthird-person perspective, \r\nplayers control protagonist \r\nGeralt of Rivia, a monster \r\nhunter known as a witcher, who \r\nis looking for his missing \r\nadopted daughter on the run \r\nfrom the Wild Hunt: an \r\notherworldly force determined \r\nto capture and use her powers. \r\nPlayers battle the game\'s many \r\ndangers with weapons and \r\nmagic, interact with non-\r\nplayer characters, and \r\ncomplete main-story and side \r\nquests to acquire experience \r\npoints and gold, which are \r\nused to increase Geralt\'s \r\nabilities and purchase \r\nequipment. Its central story \r\nhas several endings, \r\ndetermined by the player\'s \r\nchoices at certain points in \r\nthe game.','game34'),(35,'Detroit: Become Human',2018,'Detroit: Become Human is an \r\nadventure game developed by \r\nQuantic Dream and published by \r\nSony Interactive Entertainment \r\nfor PlayStation 4 on 25 May \r\n2018. The plot revolves around \r\nthree androids: Kara (Valorie \r\nCurry), who escapes the owner \r\nshe was serving to explore her \r\nnewfound sentience and protect \r\na young girl; Connor (Bryan \r\nDechart), whose job is to hunt \r\ndown sentient androids; and \r\nMarkus (Jesse Williams), who \r\ndevotes himself to releasing \r\nother androids from servitude. \r\nThey may survive or perish \r\ndepending on dialogue choices \r\nthat shape the story.','game35'),(36,'Red Dead Redemption 2',2018,'Red Dead Redemption 2[a] is a \r\nWestern action-adventure game \r\ndeveloped and published by \r\nRockstar Games. It was \r\nreleased on October 26, 2018, \r\nfor the PlayStation 4 and Xbox \r\nOne consoles. The third entry \r\nin the Red Dead series, it is \r\na prequel to the 2010 game Red \r\nDead Redemption. Set in 1899 \r\nin a fictionalized version of \r\nthe Western United States, the \r\nstory centers on outlaw Arthur \r\nMorgan, a member of the Van \r\nder Linde gang dealing with \r\nthe decline of the Wild West \r\nwhilst attempting to survive \r\nagainst government forces, \r\nrival gangs, and other \r\nenemies. The story also \r\nfollows fellow gang member \r\nJohn Marston, protagonist from \r\nthe first Red Dead Redemption.','game36'),(37,'Sekiro: Shadows Die Twice',2019,'Shadows Die Twice is an \r\naction-adventure game played \r\nfrom a third-person view. \r\nCompared to FromSoftware\'s \r\nSouls series, the game \r\nfeatures fewer role-playing \r\nelements, lacking character \r\ncreation and the ability to \r\nlevel up a variety of stats, \r\nas well as having no \r\nmultiplayer elements.[3][4][5]\r\n[6] It does, however, include \r\ngear upgrading, a skill tree, \r\nand limited ability \r\ncustomization. Rather than \r\nattacking to whittle an \r\nenemy\'s health points, combat \r\nin Sekiro revolves around \r\nusing a katana to attack their \r\npoise and balance instead, \r\nwhich eventually leads to an \r\nopening that allows for a \r\nsingle killing blow.[3][7] The \r\ngame also features stealth \r\nelements, allowing players to \r\nimmediately eliminate enemies \r\nif they can get in range \r\nundetected.[3] In addition, \r\nthe player character has the \r\nability to use various tools \r\nto assist with combat and \r\nexploration, such as a \r\ngrappling hook.[3] If the \r\nplayer character dies, they \r\nhave the option of being \r\nrevived on the spot under \r\ncertain conditions instead of \r\nrespawning at earlier \r\ncheckpoints.','game37'),(38,'Yashchuk Demo',2019,'Simulator of Yashchuk Yurii \r\nXandrovich','game38');
/*!40000 ALTER TABLE `games` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `marks`
--

DROP TABLE IF EXISTS `marks`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `marks` (
  `userId` bigint(20) NOT NULL,
  `gameId` bigint(20) NOT NULL,
  `mark` tinyint(4) NOT NULL,
  PRIMARY KEY (`userId`,`gameId`),
  KEY `gameId` (`gameId`),
  CONSTRAINT `marks_ibfk_1` FOREIGN KEY (`gameId`) REFERENCES `games` (`id`) ON DELETE CASCADE,
  CONSTRAINT `marks_ibfk_2` FOREIGN KEY (`userId`) REFERENCES `users` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `marks`
--

LOCK TABLES `marks` WRITE;
/*!40000 ALTER TABLE `marks` DISABLE KEYS */;
INSERT INTO `marks` VALUES (1,18,9),(1,21,7),(1,23,8),(1,26,10),(1,27,10),(1,28,8),(1,29,7),(1,30,8),(1,31,7),(1,32,8),(1,34,9),(1,38,10),(15,18,3),(15,19,1),(15,21,1),(15,38,10),(16,21,7),(17,32,7),(17,34,6),(17,35,9),(17,36,9),(18,32,8),(19,38,10);
/*!40000 ALTER TABLE `marks` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `play_later`
--

DROP TABLE IF EXISTS `play_later`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `play_later` (
  `userId` bigint(20) NOT NULL,
  `gameId` bigint(20) NOT NULL,
  PRIMARY KEY (`userId`,`gameId`),
  KEY `gameId` (`gameId`),
  CONSTRAINT `play_later_ibfk_1` FOREIGN KEY (`userId`) REFERENCES `users` (`id`) ON DELETE CASCADE,
  CONSTRAINT `play_later_ibfk_2` FOREIGN KEY (`gameId`) REFERENCES `games` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `play_later`
--

LOCK TABLES `play_later` WRITE;
/*!40000 ALTER TABLE `play_later` DISABLE KEYS */;
INSERT INTO `play_later` VALUES (16,24),(1,33),(17,33),(17,34),(1,35),(1,36),(1,38),(15,38),(19,38);
/*!40000 ALTER TABLE `play_later` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `users` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `nickname` varchar(30) NOT NULL,
  `email` varchar(40) NOT NULL,
  `role` enum('user','admin') NOT NULL,
  `password` varchar(70) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `nickname` (`nickname`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'RomanBoiarchuk','r.s.boyarchuk@gmail.com','admin','25e4ee4e9229397b6b17776bfceaf8e7'),(6,'user','user@gmail.com','user','ee11cbb19052e40b07aac0ca060c23ee'),(15,'kolopnyy','v.shufliak@gmail.com','user','253ea6954368ea7302378bdddaa89ec1'),(16,'user1234','user1234@gmail.com','user','b5b73fae0d87d8b4e2573105f8fbe7bc'),(17,'user1','asvwgasfasc@gmail.com','user','d8578edf8458ce06fbc5bb76a58c5ca4'),(18,'user121','userafaw@gmail.com','user','d8578edf8458ce06fbc5bb76a58c5ca4'),(19,'ravenrebel','nasty199961@gmail.com','user','d0970714757783e6cf17b26fb8e2298f');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-04-26 14:45:57
