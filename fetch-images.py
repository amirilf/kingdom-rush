import os
import plistlib
from PIL import Image


def parse_plist(plist_path):
    with open(plist_path, "rb") as f:
        plist_data = plistlib.load(f)
    return plist_data["frames"]


def extract_and_save_images(plist_data, image_path, output_dir):
    if not os.path.exists(output_dir):
        os.makedirs(output_dir)

    large_image = Image.open(image_path)

    for frame_name, frame_data in plist_data.items():
        texture_rect = frame_data["textureRect"]
        rotated = frame_data.get("textureRotated", False)
        rect = [
            int(num)
            for num in texture_rect.replace("{", "")
            .replace("}", "")
            .replace(" ", "")
            .split(",")
        ]
        box = (rect[0], rect[1], rect[0] + rect[2], rect[1] + rect[3])

        # Crop the image
        if rotated:
            cropped_image = large_image.crop(box).rotate(-90, expand=True)
        else:
            cropped_image = large_image.crop(box)

        output_path = os.path.join(output_dir, frame_name)
        cropped_image.save(output_path)


if __name__ == "__main__":
    plist_path = "file.plist"
    image_path = "file.png"
    output_dir = "media"

    plist_data = parse_plist(plist_path)
    extract_and_save_images(plist_data, image_path, output_dir)
