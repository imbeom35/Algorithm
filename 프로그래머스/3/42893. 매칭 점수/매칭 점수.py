from operator import indexOf
import re

def solution(word, pages):
    pages_info = []
    
    for i, page in enumerate(pages):
        temp = list(seperate(word, page)) + [0, i]
        pages_info.append(temp)
        
    for page in pages_info:
        url, basic_score, link_num, links, link_score, index = page
        for link in links:
            for page in pages_info:
                if link == page[0]:
                    page[4] += basic_score / link_num
    
    pages_info.sort(key=lambda x: -(x[1]+x[4]))
    
    return pages_info[0][5]


def seperate(word, page):
    basic_score = 0
    for f in re.findall(r'[a-zA-Z]+', page.lower()):
        if f == word.lower():
            basic_score += 1
    url = re.search('<meta property="og:url" content="(\S+)"', page).group(1)
    external_links = re.findall('<a href="(https://[\S]*)"', page)
    external_links_num = len(external_links)

    return url, basic_score, external_links_num, external_links