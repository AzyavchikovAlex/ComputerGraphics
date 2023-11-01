import cv2 as cv
import numpy as np
from tkinter import ttk, Tk
from PIL import ImageTk, Image
import easygui


class Solution:
    # def __init__(self, path):
    #     self.image = cv.imread(path, cv.IMREAD_GRAYSCALE)

    def __init__(self, image):
        self.image = image

    def run(self):
        self.create_interface()

        image_original = self.make_image(self.image)
        image_global_one = self.global_one(self.image)
        image_global_two = self.global_two(self.image)
        image_contrast_one = self.contrast_one(self.image)
        image_contrast_two = self.contrast_two(self.image)

        self.place_image(image_original, 50, 30, 350, 350)
        self.place_image(image_global_one, 450, 30, 350, 350)
        self.place_image(image_global_two, 850, 30, 350, 350)
        self.place_image(image_contrast_one, 450, 420, 350, 350)
        self.place_image(image_contrast_two, 850, 420, 350, 350)

    def place_image(self, image, x, y, w, h):
        label = ttk.Label(image=image)
        label.image = image
        label.place(x=x, y=y, width=w, height=h)

    def create_interface(self):
        label_original = ttk.Label(text="Исходное изображение")
        label_global_one = ttk.Label(text="Глобальная пороговая обработка(Binary)")
        label_global_two = ttk.Label(text="Глобальная пороговая обработка(Trunc)")
        label_contrast_one = ttk.Label(text="Высокочастотный фильтр (Weighted)") # new_img = alpha*old_img + beta
        label_contrast_two = ttk.Label(text="Высокочастотный фильтр (Unsharp masking)")

        label_original.place(x=50, y=5)
        label_global_one.place(x=450, y=5)
        label_global_two.place(x=850, y=5)
        label_contrast_one.place(x=450, y=400)
        label_contrast_two.place(x=850, y=400)

    def make_image(self, image):
        return ImageTk.PhotoImage(Image.fromarray(image).resize((350, 350)))

    def global_one(self, image):
        ret, th = cv.threshold(image, 0, 255, cv.THRESH_BINARY_INV + cv.THRESH_OTSU)
        return self.make_image(th)

    def global_two(self, image):
        ret, th = cv.threshold(image, 0, 255, cv.THRESH_TRUNC + cv.THRESH_OTSU)
        return self.make_image(th)

    def contrast_one(self, image):
        out = cv.addWeighted(image, 1.1, image, 0, 1)
        output = cv.addWeighted
        return self.make_image(out)

    def contrast_two(self, image):
        kernel = np.array([[0, -1, 0], [-1, 5, -1], [0, -1, 0]])
        return self.make_image(cv.filter2D(self.image, -1, kernel))

# image_path = None
image_path = easygui.fileopenbox(title='Select image', filetypes=["*.jpg"])
image = cv.imread("./Images/chirch.jpg" if image_path is None else image_path, cv.IMREAD_GRAYSCALE)

root = Tk()
root.title = "Lab2"
ms = Solution(image)
root.geometry("1250x800")
ms.run()
root.mainloop()