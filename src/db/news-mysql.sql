CREATE
DATABASE  IF NOT EXISTS `news_db` /*!40100 DEFAULT CHARACTER SET utf8mb3 */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE
`news_db`;
-- MySQL dump 10.13  Distrib 8.0.31, for Win64 (x86_64)
--
-- Host: localhost    Database: news
-- ------------------------------------------------------
-- Server version	8.0.31

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `news_list`
--

DROP TABLE IF EXISTS `news_list`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `news_list`
(
    `id`      bigint        NOT NULL AUTO_INCREMENT,
    `title`   varchar(100)  NOT NULL,
    `brief`   varchar(500)  NOT NULL,
    `content` varchar(2048) NOT NULL,
    `created` timestamp NULL DEFAULT NULL,
    `updated` timestamp NULL DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `news_list`
--

LOCK
TABLES `news_list` WRITE;
/*!40000 ALTER TABLE `news_list` DISABLE KEYS */;
INSERT INTO `news_list`
VALUES (1, 'It feels like the progress is getting reversed: how fashion fell out of love with curves',
        'Catwalks are more diverse than ever on paper. But at the high-profile shows this season, it was all about the flat stomach.',
        'Sometimes fashion is about clothes, but sometimes it is really about bodies. The Council of Fashion Designers of America awards are the highest honours awarded to US fashion designers, so you would expect the star-studded New York gala to be a showcase for extraordinary clothes. But last week the red carpet was won not by a dress, but by a body. Uncut Gems actor Julia Fox wore a cutout dress that was mostly cutout, with a side order of dress. Baring Fox from her breastbone to her thighs, it revealed a black bikini and highlighted a carved-out, rock-hard midsection, visible ribs and sinewy glutes. Her slender body, not the dress, was the outfit.\n\nThe standout trend at this season’s catwalk shows was the flat stomach. At Fendi, ribs were visible under tissue-thin knitwear tucked into cargo pants that hung below the models’ hipbones. At Versace there was a long plane of taut bare flesh between the bumster-style waistband on a pair of jeans and the tiny bra top. Second-skin catsuits came in black lace at Burberry and crystal mesh at Stella McCartney. All of these were worn on the catwalk by models with the low body fat necessary for bones, cavities and ridges of muscle to be clearly visible.\n\nThe funny thing is that catwalk models are not actually getting skinnier. The fashion search engine Tagwalk crunched the numbers, and found that out of 247 fashion shows this season, 90 included “curve” (plus-size) models, up from 62 the previous season. That 64% of brands still employ only the traditional super-slender body type on their catwalk is slow progress, but the trajectory is curving in the right direction.',
        '2022-10-01 04:10:10', NULL),
       (2, 'Can napping like a Navy Seal (for eight minutes) give you superpowers?',
        'Seal turned author Jocko Willink swears by this sleep hack – and the key is to nod off with your legs up',
        'The hack\nTaking an eight-minute nap during the day, as recommended by a retired US Navy Seal.\n\nThe test\nAccording to former Navy Seal Jocko Willink (great name), eight minutes is the ideal nap time: you wake up rested, without feeling groggy. TikTok is awash with sleep hacks, but might this one work? According to Willink, you have to “elevate your feet above your heart and then set your alarm for eight minutes, and afterwards he feels like “superman”.\n\nScience-wise, keeping your legs elevated can help blood flow, promoting faster sleep. I love a nap and usually aim for 20 minutes max, so this hack speaks to me. It’s Monday, I’m editing my book and when I hit the 3pm slump I either nap or eat biscuits – both worthy pastimes. But today, I lie on my yoga mat, elevate my legs on the nearby sofa, and set an alarm for eight minutes. I fall asleep a little faster than usual and I feel pretty good when waking up, but definitely feel as if I could sleep longer. I’m probably not in REM or deep sleep which usually comes after at least an hour of sleep, so I do feel a tad more energetic afterwards. I try this for the next few days and feel I’m getting used to the brevity of my naps. They don’t feel that different from my 20-minute naps, but the leg elevation seems to work. I wonder if I’m allowed to take, like, five mini naps a day? Willink probably wouldn’t approve. Sigh.\n\nThe verdict\nWorth a crack. It could be that my brain just likes having a little rest at that point in the day, so maybe a soothing meditation or a walk would have the same effect. I’ll keep Seal napping and keep you posted.',
        '2022-10-02 04:10:10', NULL),
       (3, 'Comedian Gallagher, famous for his watermelon-smashing routine, dies at 76',
        'Leo Gallagher, known professionally as Gallagher, was an American comedian famous for the \"Sledge-O-Matic,\" a signature sketch where he smashed a variety of foods and ended by pummeling a watermelon.',
        'Comedian Leo Gallagher, who was known simply by his last name and became famous for smashing watermelons with a mallet on stage, died on Friday morning, according to his family.\n\nHe was 76.\n\nGallagher died from organ failure while in hospice care in his Palm Springs, California, home, his son-in-law told NBC News. He had been unwell and had multiple heart attacks.',
        '2022-10-03 04:10:10', NULL);
/*!40000 ALTER TABLE `news_list` ENABLE KEYS */;
UNLOCK
TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-11-28 17:46:00
